#  An Internet Media Store
<p align="center">
  <img src="src/main/resources/assets/images/aims_cover_image.png" />
</p>

## Getting Started

Welcome to the AIMS project. Here is a guideline to help you get started.

## Folder Structure

The workspace contains the following folders, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `test`: the folder for testing purpose

## Dependency Management
### Working with Eclipse
Import the root directory of this repository after cloning under `Eclipse` -> `Open Projects from File System...` or by using EGit.

### SQLite
Import `sqlite-jdbc-3.7.2.jar` in `lib` under `Eclipse` -> `Project` -> `Properties` -> `Java Build Path` -> `Classpath` -> `Add JARs...`.


### JUnit
Import `JUnit5` library under `Eclipse` -> `Project` -> `Properties` -> `Java Build Path` -> `Modulepath` -> `Add Library...` -> `JUnit` -> `Next`.

### JavaFX
**Note:** At first, please try to run the project once, and then follow these steps.
1. Create a new `User Library` under `Eclipse` -> `Window` -> `Preferences` -> `Java` -> `Build Path` -> `User Libraries` -> `New`
2. Name it anything you want, e.g., `JavaFX15`, and include the ***jars*** under either the `lib/linux/javafx-sdk-15` directory for Linux distro or the `lib/win/javafx-sdk-15` directory for Windows in the project.
3. Include the library, e.g., `JavaFX15`, into the classpath.

### Add VM arguments
Click on `Run` -> `Run Configurations...`  -> `Java Application`, create a new launch configuration for your project and add these VM arguments:
- For Linux distro: 
> `--module-path lib/linux/javafx-sdk-15 --add-modules javafx.controls,javafx.fxml`
- For Windows:
> `--module-path lib/win/javafx-sdk-15 --add-modules javafx.controls,javafx.fxml`

## Author
- nguyenlm - Software Engeneering Student - k61
- manhvd   - Software Engeneering Student - k61
- hieudm   - ICT - k61
- thanhld  - ICT - k62

## Lù Mạnh Thắng
# Week2 Coupling
BaseController:
Common Coupling: Trong phương thức checkMediaInCart(Media media), có sự phụ thuộc vào cấu trúc nội dung của đối tượng Media.
Data Coupling: Trong cả hai phương thức checkMediaInCart(Media media) và getListCartMedia(), đều sử dụng SessionInformation.cartInstance.
AuthenticationController:
Common Coupling: sử dụng SessionInformation  nhiều vị trí để thay đổi thông tin biến static.
PaymentController:
Common Coupling: sử dụng SessionInformation.cartInstance trong emptyCart()
Control Coupling: trong payOrder() phụ thuộc vào việc kiểm tra lỗi từ các ngoại lệ PaymentException và UnrecognizedException.
Có common coupling trong các controller các class có sử dụng chung các biến static trong class như "SessionInformation"
Có stamp coupling trong class DeliveryInfo.java, Cart.java.

- Cohesion:
    + Class Cart: Communicational cohesion vì tất cả các method đều dùng dữ liệu từ CartItem.
    + Class PlaceOrderController: logical cohesion các phương thức validate không có sự liên quan đến nhau.
    + Class Delivery Info: communicational cohesion vì calculateShippingFee() thực hiện tính phí ship bằng dữ liệu của DeliveryInfo.
    + Class InterbankPayloadConverter: Coincidental cohesion có method getToday() không liên quan đến chức năng.

# Link video trình bày:
https://husteduvn.sharepoint.com/sites/DP338/Shared%20Documents/General/Recordings/Cu%E1%BB%99c%20h%E1%BB%8Dp%20k%C3%AAnh%20m%E1%BB%9Bi-20240613_002657-Meeting%20Recording.mp4?web=1&referrer=Teams.TEAMS-ELECTRON&referrerScenario=MeetingChicletGetLink.view.view