## WHERE 

``SELECT`` chọn cột - ``WHERE`` chọn hàng

``WHERE`` đứng sau ``FROM``


### Toán tử so sánh và điều kiện

| **Toán tử** | **Ý nghĩa** | **Ví dụ WHERE** | **Diễn giải** |
|:---:|:---:|:---:|:---:|
| `=` | Bằng | `diem_tb = 8` | Điểm đúng bằng 8 |
| `<>` | Khác | `lop <> 'CNTT01'` | Không thuộc lớp CNTT01 |
| `>` | Lớn hơn | `diem_tb > 8` | Điểm trên 8 (không tính 8) |
| `<` | Nhỏ hơn | `diem_tb < 5` | Điểm dưới 5 |
| `>=` | Lớn hơn hoặc bằng | `diem_tb >= 8` | Điểm từ 8 trở lên |
| `<=` | Nhỏ hơn hoặc bằng | `diem_tb <= 5` | Điểm từ 5 trở xuống |


| **Từ khóa** | **Giữ hàng khi** | **Ví dụ** |
|:---:|:---:|:---:|
| `AND` | CẢ HAI điều kiện đều đúng (thu hẹp kết quả) | `diem_tb >= 8 AND gioi_tinh = 'Nam'` |
| `OR` | ÍT NHẤT MỘT điều kiện đúng (mở rộng kết quả) | `lop = 'CNTT01' OR lop = 'CNTT02'` |
| `NOT` | Điều kiện phía sau SAI (đảo ngược) | `NOT lop = 'CNTT03'` |


### Thứ tự ưu tiên

Trong câu truy vần có nhiều điều kiên ``AND``, ``OR`` và ``NOT``

Thứ tự ưu tiên: ``NOT > AND > OR``

**Xem ví dụ:**

Mong muốn lọc ra học sinh thuộc lớp CNTT01 hoặc CNTT02 và điểm lớn hơn 8


```sql
-- SAI: 
-- Lúc này SQL thực hiện AND trước

SELECT ho_ten, lop, diem_tb
FROM sinh_vien
WHERE lop = 'CNTT01' OR lop = 'CNTT02' AND diem_tb >= 8;
```

```sql
-- ĐÚNG:
-- Cần thêm () để tránh hiểu nhầm

SELECT ho_ten, lop, diem_tb
FROM sinh_vien
WHERE (lop = 'CNTT01' OR lop = 'CNTT02') AND diem_tb >= 8;
```




## LIKE - tìm theo mẫu

| **Ký tự** | **Khớp với** | **Ví dụ mẫu** | **Kết quả** |
|:---:|:---:|:---:|:---:|
| `%` | Chuỗi bất kỳ, dài ngắn tùy ý (kể cả rỗng) | `'Nguyễn%'` | Mọi tên bắt đầu bằng Nguyễn |
| `_` | Đúng một ký tự bất kỳ | `'SV00_'` | SV001, SV002, … SV009 |
| `%` ở hai đầu | Có chứa chuỗi ở giữa | `'%Thị%'` | Mọi tên có chữ Thị |


Lọc ra sinh viên có **Thị** trong tên

> ⚠️ Không nên dùng nháy kép ("):

```sql
SELECT ho_ten AS "Họ và Tên"
FROM students
WHERE ho_ten LIKE '%Thị%';
```



> **Hoa/Thường trong LIKE tùy theo hệ quản trị**
>
> Mẫu ``nguyễn%`` có khớp với ``Nguyễn`` hay không tùy vào hệ quản trị CCSDL gọi là collation (quy tắc so chuỗi)
>
> Đừng mặc định rằng giống nhau


| **Hệ quản trị** | **LIKE mặc định** | **Muốn tìm KHÔNG phân biệt hoa/thường** |
|:---:|:---:|:---:|
| PostgreSQL | Phân biệt hoa/thường | Dùng `ILIKE` thay cho `LIKE` |
| MySQL / MariaDB | Thường KHÔNG phân biệt | Không cần làm gì thêm, mặc định đã bỏ qua hoa/thường |
| SQL Server | Thường KHÔNG phân biệt | Không cần làm gì thêm, mặc định đã bỏ qua hoa/thường |
| SQLite | Bỏ qua với chữ A–Z, nhưng vẫn phân biệt chữ có dấu (tiếng Việt) | Đưa hai vế về cùng chữ thường (xem mẹo bên dưới) |
| Oracle | Phân biệt hoa/thường | Đưa hai vế về cùng chữ thường (xem mẹo bên dưới) |


> **MẸO**
> Đưa tất cả về chữ thường trước khi so sánh

```sql
SELECT ho_ten AS "Họ và Tên"
FROM students
WHERE LOWER(ho_ten) LIKE LOWER('%Thị%');
```




## IN - thuộc danh sách

Thay vi ``OR`` nhiều lần ``IN`` gọn hơn

```sql
-- OR

SELECT lop AS "Lớp"
FROM students
WHERE lop = 'CNTT01' OR lop = 'CNTT02' OR lop = 'CNTT03';
```

```sql
-- IN: gọn hơn

SELECT lop AS "Lớp"
FROM students
WHERE lop IN ('CNTT01', 'CNTT02', 'CNTT03');
```



## WHERE - nằm trong khoảng

``WHERE a AND b`` cách viết gọn hơn của ``>= a AMD <= b``

```sql
SELECT ho_ten, diem_tb 
FROM sinh_vien
WHERE diem_tb BETWEEN 8 AND 10;
```


```sql
--- BETWEEN với ngày

SELECT ho_ten, ngay_sinh 
FROM sinh_vien
WHERE ngay_sinh BETWEEN '2005-1-1' AND '2026-12-31';
```
