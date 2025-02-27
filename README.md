# SFGameDataEditor
SpellForce game GameData.cff file editor, for modification and fixes creation

# What is it
Java GUI editor of original SpellForce game (see http://spellforce.com/) Gamedata.cff files. 

Allowing you to change almost any existing in-game ability parameter like mana usage, range, skill requirement,
ability effect, creature and unit parameters, some items parameters, buildings parameters.

IMPORTANT: 

See "What it can't do" section below to be aware of restrictions.

# What it can do
 - Editing skill requirements, i.e how many strength you need to level-up your Heavy Combat Art skill to level 7
 - Editing spell parameters, i.e. how far you can cast your "Fireball" or how many hops can make "Chain Pain"
 - Editing creature common parameters, spells, equipment, loot drop, i.e. how many strength has "Blade Nightmare", how to make Lena/Urias mortal, how to make Eloni Watcher bite you with poisonous claw
 - Editing unit common parameters, i.e. how change what blades hold dark elves assassin and how to make orc drummers mass heal instead of war crying  
 - Editing armor, weapons and miscellaneous parameters, i.e. how many strength "Amra's armor" gives you and for how much you can sell/buyout it or how far "Heartseeker" can shoot
 - Editing buildings parameters, i.e. how many resources need to build human's Quarry or what buildings are needed to produce dwarves' Defender
 - Editing spell scrolls and spells, i.e. how to make Pain level 1 scroll teach you Torture level 14
 - Editing workers and heroes runes parameters i.e. how make Dwarves be revived at night like Dark Elves or how to add Warrior Kord more strength and fight speed
 - Editing units and buildings plans, i.e. how to give elves ability to build Fishman's Hat or let Orcs summon Clerics
 - Editing chest corpse loot, like chests, logs, corpses, skeletons etc.
 - Editing player stats parameters, i.e. how many XP you should have to up to level 6 or what armor/health modifier you have on that level
 - Creating compact sf-mod files, which stores your modifications
 - Loading sf-mod files created by other users
 - Merging sf-mod files with your GameData.cff files to get modificated data, which you can test in game

# What it can't do
 - Add new elements. It's tricky to explain easy, but game will crush if we will add anything into Gamedata.cff file
 - Currently NO localization for gui on different languages (in progress) 
 - No other languages except English, Russian, German, French, Spanish, Italian, Polish

# How to launch it
 - Install, at least, Java 7 from Oracle site (see https://www.java.com/download/)
 - Download Editor-alpha-9.jar from (https://github.com/Hokan-Ashir/SFGameDataEditor/tree/master/Editor/bin)
 - Double-click on Editor-alpha-8.jar OR run with "java -jar Editor-alpha-9.jar" command in console
 
# How to use it
 - After launch you can select editor's language
 - Then you must select, at least, original file (or already modificated file, see NOTE below); and sf-mod file optionally
 - After changing different parameters you can create sfmod-file, which will consists of changes you made via "Create sf-mod file" button
 - You can also load sf-mod-file during editing with "Load sf-mod file" button
 WARNING:
 This will erase all your current changes
 - Also you can create so called ".mod" file which is simply your original file with changes, located in same directory as your original file
 NOTE:
 Because of compatibility, editor stores hash of original file based on which sf-mod-file created. 
 This is made to exclude file format errors. 
 So if you will try to load sf-mod file, which was created not based on original file, you selected, you will have corresponding message.
 
# What YOU can do
  - Create modified GameData.cff files for your own need, or distribute them with people, who can't access editor for some reasons
  - Create sf-mod-files in terms of "mods" to original game, which people can use with ease, cause sf-mod-files have much lesser size
  - Create collections of sf-mod-files with this action chain: 
    - Load original file, i.e. GameData.cff
    - Load sf-mod-file_1 - on this stage you will have GameData.cff.mod with sf-mod-file_1 applied to it
    - Exit
    - Rename GameData.cff.mod to GameData.cff.mod1 i.e., for exclude name clashing
    - Load GameData.cff.mod1
    - Load sf-mod-file_2 - on this stage you will have GameData.cff.mod with sf-mod-file_1 AND sf-mod-file_2 applied to it
    - ...
 
# How YOU can help
  - Report new issues about bugs, typos, code advises etc. via https://github.com/Hokan-Ashir/SFGameDataEditor/issues/new
  - Report of spell parameters which you aware of, those which marked as "???"
  - Correct i18n files
  - Download source code, change, refactor it, write me to commit changes
  - Fork this hub and make own version of editor
 
# What inside
  - Java 7 - for diamonds and multiple catch exceptions (Java 8 is not supported by IDEA GUI Designer)
  - Maven - as build tool
  - Swing - for GUI, obviously
  - H2 - for storing parsed data in form of objects and tables
  - ORMLite - for ORM surely
  - XDeltaEncoder - for making binary differences between files (see https://github.com/mantlik/xdeltaencoder)
  - SHA-512 - for differencing original/modification files
  - Winzipaes - for encrypted zip-files creation (see https://code.google.com/p/winzipaes/ or MAVEN central repository)
  - bouncycastle - for encryption via AES-algorithm (see http://www.bouncycastle.org/latest_releases.html)
  
# SfMod-files format
  OriginalFile = file, you've chosen as original in file selection dialogue
  
  ModificationFile = file which storing all your current changes
  - SfMod-file creation procedure
    - TmpFile = XDeltaEncoder(OriginalFile, ModificationFile, DIFF)
    - HASH = SHA-512(OriginalFile)
    - SfMod-file = winzipaes(TmpFile, HASH)
  - SfMod-file loading procedure
    - HASH = SHA-512(OriginalFile)
    - TmpFile = winzipaes(SfMod-file, HASH)
    - ModificationFile = XDeltaEncoder(OriginalFile, TmpFile, MERGE)

# TODO
 - Add more flexible ability to merge multiple sf-mod files
 - Extend sf-mod-files format to include description, maybe picture
 - Add filtration 
 - Add icons for objects and creatures (in progress)

# Special thanks
 - This application won't be possible without information grabbed from this forum - http://spellforcefanforum.hostoi.com/index.php
 - Thanks to rupuzioks and VolterPL for parsing GameData.cff format and gathering info from official english and german sites
 - You can also support VolterPL with his own .NET editor, which you can grab here - http://spellforcefanforum.hostoi.com/viewtopic.php?f=14&t=242&sid=13dc65505d9b57498789cd9574831658, hope author won't be against

# Contacts
 - Report new issue here via https://github.com/Hokan-Ashir/SFGameDataEditor/issues/new
 - achkasov.anton.92@gmail.com
