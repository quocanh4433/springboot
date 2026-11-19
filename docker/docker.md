## Docker = Isolated Process
![Docker](./imgs/img_docker_01.png)

Để cô lập container docker sử dụng Linux ernel:

- **Namespace**: cô lập network, process, filesystem của các app

- **Control groups (cgroups)**: giới hạn tài nguyên CPU và RAM

Do cần làm việc với Linux kernel, nên docker desktop sẽ cung cấp máy ảo linux gọn nhẹ cho Window (WSL2) và Mac (Linux VM)





## Kiến trúc Docker

Docker theo mô hinh **Client - Server**

![Docker](./imgs/img_docker_02.jfif)

Gồm 3 phần chính

1. **Docker CLI:** 
    - nơi tương tác với docker thông qua command line, gửi yêu cầu cho Docker Host thông qua REST API

2. **Docker Host:** môi trường chạy Docker Daemon (dockerd) và quản lí Docker Object:
    - Docker Daemon (dockerd): tiếp nhận yêu cầu
        - Một background processing chạy với quyền ``root`` bên trong hệ thống. 
        - Do quyền ``root`` quá nguy hiểm nên dẫn dến sự ra đời của ``Podman``
    - Images: bản mẫu tạo Containers 
    - Containers: môi trường chạy ứng dụng
    - Network: kết nối giữa các Containers
    - Volumes: lưu trữ dữ liệu lâu dài 

3. **Docker Register:** nơi lưu trữ và phân phối Docker Images
    - Docker Hub
    - Amazon ECR
    - GitHub Container Registry





## Dockerfile - Docker Image - Docker Compose

| Dockerfile    | Docker Image | Docker Compose |
| -------- | -------- | -------- |
| Bản hướng dẫn để đóng gói ứng dụng | Sản phẩm tạo ra từ Dockerfile | Công cụ quản lí nhiều Container chạy cùng lúc |

![Docker](./imgs/img_docker_03.jfif)

### 1. Dockerfile

```FROM:``` chọn image nền (node, python, ubuntu)

``WORKDIR:`` thư mục làm việc chính trong Contianer. Mọi lệnh ``RUN``, ``CMD``, ``COPY`` đều nằm trong thư mục này

``RUN:`` thực thi các lệnh terminal trong quá trình build image (cài đặt packeage/dependencies)

``EXPOSE:`` khai báo port cho Container (port này vẫn chưa publish ra bên ngoài)

``CMD:`` lệnh mặc định thực thi khi Container bắt đầu chạy, chỉ 1 lênh ``CMD`` trong dockerfile

``COPY / ADD:`` sao chép tệp hoặc thư mục từ máy host vào image

