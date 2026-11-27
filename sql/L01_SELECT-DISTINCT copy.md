## SELECT ... FROM ... 

```sql
SELECT
  ho_ten  AS "Họ và tên",
  lop     AS "Lớp",
  diem_tb AS "Điểm trung bình"
FROM sinh_vien;
```




## DISTINCT

Bảng students:
|  id  |  name  |	 class  |
| ----- |  ----- |  ----- |
| 1 |  An |  A1 |
| 2 |  Bình |  A1 |
| 3 |  An |  A1 |
| 4 |  An |  A2 |


### DISTINCT: trên 1 cột

```sql
SELECT DISTINCT name
FROM students;
```

Kết quả

|  name  |	
|  -----  |  
|  An  |  
|  Bình  |  




### DISTINCT: trên nhiều cột

```sql
SELECT DISTINCT name, class
FROM students;
```

Lúc này so sanh cập (name, class) lúc này (An, A1) xuất hiện 2 lần nên loại

Kết quả

|  name  |	 class  |
|  ----- |  ----- |
|  An |  A1 |
|  Bình |  A1 |
|  An |  A2 |


> Nếu xét trên ``(name, class, id)`` mà id là ***unique*** thì ``DISTINCT`` mất tác dụng


### DISTINCT có NULL

Nếu có nhiều dòng NULL thi


### DISTINCT và COUNT()

Không đếm NULL - Đếm trùng
```sql
SELECT COUNT(name)
FROM students;
-- 4
```

Không đếm NULL - Không đếm trùng
```sql
SELECT COUNT(DISTINCT name)
FROM students;
-- 2
```
