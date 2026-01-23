# Weather Application

A progressive mobile development project building a complete weather application through multiple learning modules. This project demonstrates fundamental mobile development concepts including UI structure, API integration, data management, authentication, and responsive design.

## 📱 Final Application Overview

The completed weather application will feature:
- **Real-time weather data** for current conditions, today's hourly forecast, and weekly predictions
- **Location services** with GPS geolocation and city search functionality
- **User authentication** via Google/GitHub OAuth
- **Personal diary** to track daily feelings and weather-related notes
- **Statistics dashboard** showing mood patterns and weather correlations
- **Calendar integration** for viewing historical entries
- **Professional UI/UX** with charts, graphs, and intuitive navigation

---

## 🗂️ Project Structure

This project is divided into **5 progressive modules**, each building upon the previous one:

### Module 01: Structure and Logic ✅ COMPLETED
**Repository:** `mobileModule01`  
**Project Name:** `weather_app`

**What was built:**
- Basic application structure with bottom navigation
- Three main tabs: Currently, Today, Weekly
- Top app bar with search functionality
- Geolocation button integration
- Tab switching (both tap and swipe)
- Responsive layout foundation

**Key learnings:**
- Mobile app navigation patterns
- State management basics
- UI component organization
- User input handling

---

### Module 02: API and Data Management 🔄 IN PROGRESS
**Repository:** `mobileModule02`  
**Project Name:** `medium_weather_app`

**Goals:**
- Implement GPS-based geolocation
- Integrate weather APIs (OpenMeteo)
- Add geocoding for city name resolution
- Create dynamic city search with suggestions
- Display real weather data across all tabs
- Handle API errors and edge cases

**New features:**
- Live weather data display
- Location permission handling
- API integration with error handling
- Search autocomplete functionality

---

### Module 03: Design 📋 UPCOMING
**Repository:** `mobileModule03`  
**Project Name:** `advanced_weather_app`

**Planned improvements:**
- Professional UI design with cohesive theme
- Background images and visual polish
- Weather data visualization (charts/graphs)
- Enhanced search bar design
- Temperature curves for daily/weekly views
- Weather icons and condition indicators

---

### Module 04: Authentication and Database 📋 UPCOMING
**Repository:** `mobileModule04`  
**Project Name:** `diary_app`

**Planned features:**
- OAuth authentication (Google/GitHub)
- Firebase/cloud database integration
- Personal diary entry system
- CRUD operations for diary entries
- User session management
- Secure data storage

**Database schema:**
- User email
- Entry date
- Entry title
- Daily feeling/mood
- Entry content

---

### Module 05: Advanced Data Management 📋 UPCOMING
**Repository:** `mobileModule05`  
**Project Name:** `advanced_diary_app`

**Final features:**
- Enhanced profile page with statistics
- Recent entries display
- Mood/feeling analytics with percentages
- Calendar-based agenda view
- Entry filtering by date
- Real-time data updates
- Complete CRUD functionality

---

## 🛠️ Technology Stack

- **Framework:** Flutter/React Native/Kotlin (based on your implementation)
- **Authentication:** Firebase Auth / OAuth 2.0
- **Database:** Firebase Firestore / Cloud Database
- **APIs:** 
  - OpenMeteo Weather API
  - OpenMeteo Geocoding API
- **State Management:** (Your chosen solution)
- **UI Components:** Material Design / Custom components

---

## 📋 Prerequisites

- Development environment set up for mobile development
- API keys for weather services
- Firebase/authentication provider account
- Mobile device or emulator for testing

---

## 🚀 Getting Started

### Module 01 - Structure and Logic (Current)

```bash
# Clone the repository
git clone [repo-url]

# Navigate to Module 01
cd mobileModule01/weather_app

# Install dependencies
[your package manager install command]

# Run the application
[your run command]
```

**Current functionality:**
1. Launch the app - defaults to "Currently" tab
2. Enter a city name in search bar - displays across all tabs
3. Click geolocation button - shows "Geolocation" text
4. Switch tabs by tapping or swiping

---

## 📚 Module Progression Guide

Each module builds on the previous one by copying and extending functionality:

1. **Complete current module** requirements
2. **Copy project** to new module folder
3. **Add new features** as specified
4. **Test thoroughly** before moving forward
5. **Submit for peer evaluation**

---

## ✅ Current Progress

- [x] Module 01: Basic structure with navigation (COMPLETED)
- [ ] Module 02: API integration and geolocation
- [ ] Module 03: Professional design and visualization
- [ ] Module 04: Authentication and database
- [ ] Module 05: Advanced features and analytics

---

## 🎯 Learning Objectives

Throughout this project series, you'll learn:

- Mobile application architecture and navigation patterns
- RESTful API integration and data fetching
- Location services and permissions
- User authentication flows
- Cloud database integration (CRUD operations)
- State management across components
- Responsive UI design principles
- Data visualization techniques
- Error handling and edge cases
- User experience optimization

---

## 📖 Documentation References

- Weather API: [OpenMeteo Documentation](https://open-meteo.com/)
- Geocoding API: [OpenMeteo Geocoding](https://open-meteo.com/en/docs/geocoding-api)
- [Your framework documentation links]

---

## 🎓 Acknowledgments

- Piscine Mobile curriculum designers
- Peer evaluators and fellow students
- API providers (OpenMeteo)

---

**Last Updated:** 23-01-2026  
**Current Module:** 01 - Structure and Logic  
**Next Milestone:** API Integration (Module 02)