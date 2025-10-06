# SpiderSense

A Minecraft Fabric mod that enhances your awareness by highlighting hostile mobs and slimes that are looking at you.

## English

### Features

- **Continuous Surveillance**: No need to interact with beds - highlighting works constantly while you're in survival mode
- **Intuitive Outlines**: Hostile mobs and slimes that can see you are outlined on the client side for easy identification
- **Visual Glow**: Mobs receive a glowing effect on the server side, making them stand out even in darkness
- **Survival Mode Only**: Mod only activates in survival mode, so creative/building won't be disturbed
- **Range Adaptive**: Detects mobs within an 8-block radius around your position

### How It Works

The mod continuously scans for MobEntities (hostile mobs and slimes) within 8 blocks of the player. When a mob has line of sight to the player (`canSee(player)` returns true), it gets highlighted:

- **Client Side**: White outline appears around the mob
- **Server Side**: Mob glows with a glowing effect for 60 seconds

This creates a "Spider-Sense" like ability, alerting you to nearby threats that are aware of your presence.

### Installation

#### Player Installation

1. Download the latest release from [GitHub Releases](https://github.com/Nort8985/SpiderSense-1.21.9/releases)
2. Place the .jar file in your Minecraft `mods` folder
3. Ensure you have Fabric Loader and Fabric API installed
4. Launch Minecraft with Fabric

#### Dependencies

- Minecraft 1.21.9
- [Fabric Loader](https://fabricmc.net/use/) >= 0.17.2
- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) >= 0.134.0

### Building from Source

If you want to build the mod yourself:

```bash
git clone https://github.com/Nort8985/SpiderSense-1.21.9.git
cd SpiderSense-1.21.9
./gradlew build
```

The built .jar will be in `build/libs/`.

## Русский

### Функции

- **Постоянное наблюдение**: Не нужно взаимодействовать с кроватями - выделение работает постоянно в режиме выживания
- **Интуитивные контуры**: Враждебные мобы и слизи, которые вас видят, обведены контуром на стороне клиента для легкого распознавания
- **Визуальное свечение**: Мобы получают эффект свечения на стороне сервера, что делает их заметными даже в темноте
- **Только режим выживания**: Мод активируется только в режиме выживания, так что творческий/строительство не будет потревожено
- **Адаптивный диапазон**: Обнаруживает мобов в радиусе 8 блоков вокруг вашей позиции

### Как это работает

Мод постоянно сканирует MobEntities (враждебные мобы и слизи) в радиусе 8 блоков от игрока. Когда моб имеет линию видимости к игроку (`canSee(player)` возвращает true), он выделяется:

- **Сторона клиента**: Белый контур появляется вокруг моба
- **Сторона сервера**: Моб светится с эффектом свечения в течение 60 секунд

Это создает способность вроде "Чувства Паука", оповещая вас о близких угрозах, которые осведомлены о вашем присутствии.

### Установка

#### Установка для игрока

1. Скачайте последний релиз из [GitHub Releases](https://github.com/Nort8985/SpiderSense-1.21.9/releases)
2. Поместите .jar файл в папку Minecraft `mods`
3. Убедитесь, что у вас установлены Fabric Loader и Fabric API
4. Запустите Minecraft с Fabric

#### Зависимости

- Minecraft 1.21.9
- [Fabric Loader](https://fabricmc.net/use/) >= 0.17.2
- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) >= 0.134.0

### Сборка из исходного кода

Если вы хотите собрать мод самостоятельно:

```bash
git clone https://github.com/Nort8985/SpiderSense-1.21.9.git
cd SpiderSense-1.21.9
./gradlew build
```

Собранный .jar будет в `build/libs/`.

## Авторы

- **Автор**: Nort8985
- **Оригинальная идея**: Основано на моде "Monsters in the Closet" от Minenash
- **Лицензия**: MIT License

## Вклад

Не стесняйтесь открывать issues или pull requests, если у вас есть предложения или вы нашли баги!

## Журнал изменений

### v1.0.5
- Полная переделка: Изменено на постоянное выделение (не основанное на кроватях)
- Добавлена поддержка слизей
- Переименовано в SpiderSense
- Убраны требования взаимодействия с кроватями
- Ограничение режима выживания

### v1.0.3
- Начальная версия
