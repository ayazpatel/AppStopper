# AppStopper

## 📌 Overview
AppStopper is an Android application that blocks specific apps from running using the **Accessibility Service**. It runs in the background as a **system service** and can only be uninstalled if **Device Admin permissions** are disabled with a password.

---

## 🎯 Features
- ✅ **Block specific apps** from opening (Instagram, Snapchat, PUBG, etc.).
- 🔒 **Runs as a system service** with Accessibility permissions.
- 🛑 **Prevents uninstallation** unless Device Admin is manually disabled.
- 🔐 **Password-protected admin disable** to ensure security.
- 🚀 **Auto-start on boot** for continuous protection.

---

## 🛠️ Setup & Installation

### **1️⃣ Enable Device Admin & Accessibility**
1. Install the APK.
2. Grant **Device Admin** permission when prompted.
3. Enable **Accessibility Service** for AppStopper.
4. The app will now run in the background and block specified apps.

### **2️⃣ How to Uninstall?**
1. Open the **Settings** app.
2. Navigate to **Device Admin Apps**.
3. Select **AppStopper** and disable it (Password Required).
4. Now, you can uninstall the app normally.

---

## 📜 Permissions Required
| Permission | Reason |
|------------|--------|
| `android.permission.RECEIVE_BOOT_COMPLETED` | Starts service on device boot. |
| `android.permission.BIND_DEVICE_ADMIN` | Prevents uninstallation & adds security. |
| `android.permission.SYSTEM_ALERT_WINDOW` | Required for Accessibility Service. |
| `android.permission.FOREGROUND_SERVICE` | Keeps the app running in the background. |

---

## 👨‍💻 Developer Guide
### **Project Structure**
```
app/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/ayaz/appstopper/
 │   │   │   ├── MainActivity.java
 │   │   │   ├── AppBlockerService.java
 │   │   │   ├── BootReceiver.java
 │   │   │   ├── DAR.java (Device Admin Receiver)
 │   │   ├── res/
 │   │   │   ├── xml/
 │   │   │   │   ├── accessibility_service_config.xml
 │   │   │   │   ├── device_admin_policies.xml
 │   │   ├── AndroidManifest.xml
```

### **How to Build & Run?**
1. Clone the repository:
   ```sh
   git clone https://github.com/YOUR_USERNAME/AppStopper.git
   cd AppStopper
   ```
2. Open the project in **Android Studio**.
3. Build & Run on a **physical device** (not emulator).
4. Grant necessary permissions as prompted.

### **How to Add More Blocked Apps?**
- Modify the `blockedApps` array in `AppBlockerService.java`:
  ```java
  private final String[] blockedApps = {
      "com.instagram.android",
      "com.snapchat.android",
      "com.pubg.imobile",
      "com.whatsapp" // Add new apps here
  };
  ```

---

## 🚀 Contributing
We welcome contributions! 🛠️
1. **Fork the repository** on GitHub.
2. **Create a new branch** (`feature-new-blocking-method`).
3. **Commit your changes** and push to your branch.
4. **Create a pull request (PR)** for review.

---

## 📄 License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## ⭐ Credits
Developed by **Ayaz** ✨

If you find this app useful, **give it a ⭐ on GitHub!** 🚀

