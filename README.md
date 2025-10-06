# SpiderSense

A Minecraft Fabric mod that enhances your awareness by highlighting hostile mobs and slimes that are looking at you.

## Features

- **Continuous Surveillance**: No need to interact with beds - highlighting works constantly while you're in survival mode
- **Intuitive Outlines**: Hostile mobs and slimes that can see you are outlined on the client side for easy identification
- **Visual Glow**: Mobs receive a glowing effect on the server side, making them stand out even in darkness
- **Survival Mode Only**: Mod only activates in survival mode, so creative/building won't be disturbed
- **Range Adaptive**: Detects mobs within an 8-block radius around your position

## How It Works

The mod continuously scans for MobEntities (hostile mobs and slimes) within 8 blocks of the player. When a mob has line of sight to the player (`canSee(player)` returns true), it gets highlighted:

- **Client Side**: White outline appears around the mob
- **Server Side**: Mob glows with a glowing effect for 60 seconds

This creates a "Spider-Sense" like ability, alerting you to nearby threats that are aware of your presence.

## Installation

### Player Installation

1. Download the latest release from [GitHub Releases](https://github.com/Nort8985/SpiderSense-1.21.9/releases)
2. Place the .jar file in your Minecraft `mods` folder
3. Ensure you have Fabric Loader and Fabric API installed
4. Launch Minecraft with Fabric

### Dependencies

- Minecraft 1.21.9
- [Fabric Loader](https://fabricmc.net/use/) >= 0.17.2
- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) >= 0.134.0

## Building from Source

If you want to build the mod yourself:

```bash
git clone https://github.com/Nort8985/SpiderSense-1.21.9.git
cd SpiderSense-1.21.9
./gradlew build
```

The built .jar will be in `build/libs/`.

## Credits

- **Author**: Nort8985
- **Original Concept**: Based on the "Monsters in the Closet" mod by Minenash
- **License**: MIT License

## Contributing

Feel free to open issues or pull requests if you have suggestions or find bugs!

## Changelog

### v1.0.5
- Complete rewrite: Changed to continuous highlighting (not bed-based)
- Added slime support
- Renamed to SpiderSense
- Removed bed interaction requirements
- Survival mode restriction

### v1.0.3
- Initial version
