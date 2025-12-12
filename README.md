# HPX Portfolio Android App

A beautiful Android portfolio application showcasing your web development skills and projects. This app converts your web portfolio into a native Android experience using WebView.

## Features

- 🎨 **Beautiful UI**: Stunning cosmic and nature themes with smooth animations
- 🌓 **Theme Switching**: Toggle between dark cosmic theme and light nature theme
- 📱 **Responsive Design**: Optimized for all Android devices
- ⚡ **Fast Performance**: Optimized WebView with hardware acceleration
- 🎯 **Full-Screen Experience**: Immersive edge-to-edge display
- 🔄 **Smooth Animations**: Floating particles, leaves, and interactive elements
- 📊 **Portfolio Sections**: Home, About, Skills, Projects, and Contact

## Tech Stack

- **Language**: Kotlin
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Build System**: Gradle with Kotlin DSL
- **UI**: WebView with HTML/CSS/JavaScript

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── assets/
│   │   │   └── portfolio/          # Your web portfolio files
│   │   │       ├── index.html
│   │   │       ├── styles.css
│   │   │       ├── script.js
│   │   │       └── portfolio/      # Assets (images, etc.)
│   │   ├── java/
│   │   │   └── com/example/hpx_test_01/
│   │   │       └── MainActivity.kt  # Main activity with WebView
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── colors.xml      # App colors
│   │   │   │   ├── strings.xml     # App strings
│   │   │   │   └── themes.xml      # App theme
│   │   │   └── ...
│   │   └── AndroidManifest.xml
│   └── ...
└── build.gradle.kts
```

## Building the App

### Prerequisites

- Android Studio (latest version recommended)
- JDK 11 or higher
- Android SDK 34

### Build Steps

1. **Clone or open the project in Android Studio**

2. **Sync Gradle files**
   ```bash
   ./gradlew sync
   ```

3. **Build the APK**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Install on device/emulator**
   ```bash
   ./gradlew installDebug
   ```

The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

## Customization

### Update Portfolio Content

To update your portfolio content, modify the files in `app/src/main/assets/portfolio/`:

- `index.html` - Main HTML structure
- `styles.css` - Styling and animations
- `script.js` - Interactive functionality
- `portfolio/assets/` - Images and other assets

### Change App Name

Edit `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Your App Name</string>
```

### Change App Colors

Edit `app/src/main/res/values/colors.xml`:
```xml
<color name="primary_dark">#29103A</color>
<color name="accent">#8121D0</color>
<!-- Add more colors -->
```

### Change App Icon

Replace the launcher icons in:
- `app/src/main/res/mipmap-*/ic_launcher.png`
- `app/src/main/res/mipmap-*/ic_launcher_round.png`

## Features Explained

### WebView Configuration

The app uses an optimized WebView with:
- JavaScript enabled for interactive features
- DOM storage for theme persistence
- Hardware acceleration for smooth animations
- Mixed content support for external resources

### Theme System

The portfolio includes two beautiful themes:
- **Cosmic Theme**: Dark purple background with stars, moon, and cosmic particles
- **Nature Theme**: Light background with mountains, clouds, birds, and falling leaves

### Performance Optimizations

- Low-end device detection
- Throttled scroll and mouse events
- Optimized particle counts
- Efficient animation loops
- Lazy loading of resources

## Permissions

The app requires the following permissions:
- `INTERNET` - For loading external resources (if any)
- `ACCESS_NETWORK_STATE` - For checking network connectivity

## Known Issues

- Some animations may be reduced on low-end devices for better performance
- External links will open within the app (can be modified to open in browser)

## Future Enhancements

- [ ] Add splash screen
- [ ] Implement deep linking
- [ ] Add offline support
- [ ] Push notifications for updates
- [ ] Share functionality
- [ ] Dark mode system integration

## License

This project is open source and available under the MIT License.

## Contact

For questions or support, please contact through the portfolio contact form.

---

**Built with ❤️ using Kotlin and WebView**
