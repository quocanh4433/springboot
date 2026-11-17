## Docker = Isolated Process
![Docker](./imgs/img_docker_01.png)

Để cô lập container docker sử dụng Linux kernel:

- **Namespace**: cô lập network, process, filesystem của các app

- **Control groups (cgroups)**: giới hạn tài nguyên CPU và RAM

Do cần làm việc với Linux kernel, nên docker desktop sẽ cung cấp máy ảo linux gọn nhẹ cho Window (WSL2) và Mac (Linux VM)

## Kiến trúc Docker

Docker the mô hinh **Client - Server**

![Docker](./imgs/img_docker_02.jfif)
img_docker_02

## Docker daemon = dockerd

Một **background processing** chạy với quyền ``root`` bên trong hệ thống. 

Do quyền ``root`` quá nguy hiểm nên dẫn dến sự ra đời của ``Podman``

