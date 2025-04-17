# 🎵 LyricManager - A Mini Music Community App

LyricManager is a simple console-based Java application that simulates a music platform where **artists** can create and manage albums and songs, and **members** can follow artists, comment on songs, and suggest lyric edits. This project is designed as a basic object-oriented system to demonstrate user interaction, media management, and collaboration features.

---

## 📦 Features

### 👩‍🎤 Artists
- Create and manage **albums**.
- Add **songs** with lyrics to albums.
- View and edit song details and lyrics.
- Receive and manage **suggestions** from members.
- View **followers** and profile info.

### 👥 Members
- **Follow/unfollow** artists.
- **Search** for songs, albums, or artists.
- View lyrics and leave **comments** or **replies**.
- Suggest lyric edits to songs.

### 🔍 General
- Search functionality across the platform.
- Console-based UI with menus and prompts.
- Simple seed data for demonstration.

---

## 🧩 Code Structure

```plaintext
src/
├── org.example
│   ├── Main.java                  # Entry point and UI control
│   ├── Users/
│   │   ├── User.java              # Abstract base user class
│   │   ├── Artist.java            # Artist role with albums and suggestions
│   │   └── Member.java            # Member role with follows and comments
│   └── Objects/
│       ├── Album.java             # Album containing multiple songs
│       ├── Song.java              # Song metadata and lyrics
│       ├── Lyric.java             # Lyric lines and editing logic
│       ├── Comment.java           # Comment system with nested replies
│       ├── Suggest.java           # Lyric suggestion logic
│       └── Finder.java            # Utility for finding songs, albums, artists
---
🛠️ Technologies Used
- Java (JDK 17+ recommended)

- Console I/O for user interaction

- OOP Design Patterns (encapsulation, inheritance)
---
🚀 Getting Started

1.Clone the repo:

2.Compile and run the app: Use your favorite Java IDE or terminal

3.Use the menu to create accounts, view songs, and explore functionality.

---

🌱 Seeded Demo Users
To test the platform, several artists and songs are already pre-loaded in the Main.java file.

Example:

- Artist: Gorbeh_power

- Password: gorba_mew

- Has a song: "you meowed me" with a full lyric.

---

📄 License
This project is open-source and free to use for educational or personal purposes.

---

Created by [@Zari-1384]

