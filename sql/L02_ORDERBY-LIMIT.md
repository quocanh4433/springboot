## ORDER BY

- ``ASC`` tăng dần (mặc định)

- ``DESC`` giảm dần

Bảng sinh_vien

|  lop  |  ho_ten  |	diem  |
| ---  |  ---  |  ---  |
| CNTT1 | Dũng | 8.0 |
| CNTT1 | An | 9.0 |
| CNTT1 | Bình | 8.0 |
| CNTT1 | Cường | 8.0 |
| CNTT2 | Minh | 9.0 |
| CNTT2 | Hà | 9.0 | 
		

```sql
SELECT diem
FROM sinh_vien
ORDER BY diem;
```

Kết quả

|	diem  |
|  ---  |
| 8.0 |
| 8.0 |
| 8.0 |
| 9.0 |
| 9.0 |
| 9.0 | 


### ORDER BY trên nhiều cột

```sql
SELECT lop, ho_ten, diem
FROM sinh_vien
ORDER BY lop ASC, diem DESC, ho_ten ASC;
```

Sắp theo tiêu chí


|  Ưu tiên  |  Cột  |  Tiêu chí  |
|  ---  |  ---  |  ---  |
|  1  |  ``lop``  |  tăng dần  |
|  2  |  ``diem``  |  cùng ``lop`` giảm dần  |
|  3  |  ``ho_ten``  |  cùng ``lop`` cùng ``diem`` tăng dần   |


Kết quả

|  lop  |  ho_ten  |	diem  |
| ---  |  ---  |  ---  |
| CNTT1 | An | 9.0 |
| CNTT1 | Bình | 8.0 |
| CNTT1 | Cường | 8.0 |
| CNTT1 | Dũng | 8.0 |
| CNTT2 | Hà | 9.0 | 
| CNTT2 | Minh | 9.0 |

Cùng lop ``CNTT1`` cùng diem ``8.0`` tên được sắp xếp tăng dần: Bình - Cường Dũng

Cùng lop ``CNTT2`` cùng diem ``9.0`` tên được sắp xếp tăng dần: Hà - Minh


```sql
ORDER BY A DESC, B ASC, C DESC
```

> Sắp xếp theo A trước. Nếu A bằng nhau thì xét B. Nếu A và B bằng nhau thì xét C.




## LIMIT

Chỉ lấy vài dòng


```sql
SELECT lop, ho_ten, diem
FROM sinh_vien
ORDER BY lop ASC, diem DESC, ho_ten ASC
LIMIT 3;
```

### LIMIT với ngày

Giới hạn 3 user trẻ nhất

```sql
SELECT name, date_of_birth
FROM users
ORDER BY date_of_birth DESC
LIMIT 3;

-- date_of_birth giảm dần từ mới nhất → cũ nhất
```

> Ghép ``ORDER BY`` với ``LIMIT`` là bạn trả lời được vô số câu hỏi “top N”: 
