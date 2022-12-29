# The Nightrunners
### A 2D mobile platformer for Android devices. 

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209905365-f0eb7ec3-cf22-4eec-adf0-d5a05e976d30.png"></div>


## Contents
* [Introduction](#introduction)
* [Installation](#running-the-game)
  * [Prerequisites](#prerequisites) 
  * [Building](#building)
* [Gameplay](#gameplay)
  * [The Goal](#the-goal)
  * [Weapons](#weapons)
  * [Enemy Units](#enemy-units)
  * [World Objects and People](#world-objects-and-people)
* [Controls](#controls)
* [Lore](#lore)
  * [The World](#the-world)
  * [Nightrunners](#nightrunners)
  * [Security Alpha](#security-alpha)
* [Acknowledgements](#acknowledgements)
  * [Game Engine](#game-engine)
  * [Assets - Drawable](#assets---drawable)
  * [Sound](#sound) 




## Introduction
Welcome to <i>The Nightrunners</i>. Thank you for taking the time to play this game. <i>The Nightrunners</i> is a 2D platformer game in a tech-noir setting in an era set in the future. You, the player, take the role of a Runner — a member an underground network called The Nightrunners. As a Runner, you specialise in physically transporting data from one client to another. It may be the future, but it is not without its own dystopian elements. Advanced technology also led to the rise of mass surveillance, and before anything is sent from one place to another online, it is intercepted by the government and scrutinized thoroughly to ensure no plots of mischief or destruction. 

In the attempt to reclaim personal privacy, The Nightrunners network of Runners was conceived. Because transporting data from one point to another can come from anyone and be for anyone, a Runner can find themselves in very interesting places and situations. In-game, this is conveyed through beautiful parallax backgrounds that change as the Runner advances into the next level. While the sceneries and the path to the teleportation box may vary, there is one constant danger whose purpose is to eliminate the Runner and its kind: Security Alpha. 



## Running the Game

### Prerequisites
* <i>The Nightrunners</i> was developed using Android Studio. [Download it here.](https://developer.android.com/studio) 
* This app is written with Java 8. 
* In order to run the project, you need an Android emulator running with a minimum SDK of Android 21 and up to SDK 31. 
* The app is tested and guaranteed to run on a Pixel 2 API 30 emulator running Android 11.0 with a 1080x1920: xxhdpi resolution. 
* The app was also tested and guaranteed to run on a physical Samsung Galaxy Note 8 machine running Android 9.

### Building
To build <i>The Nightrunners</i>: 
  1. Once downloaded, open up Android Studio and import the project.
  2. Build the project from the gradle file through Build > Make Project.
  3. Run the project using an emulator or a physical device that matches the conditions listed on the [prerequisites section](#prerequisites).
  4. Run the project. 

## Gameplay

### The Goal
The goal in every level is simple: successfully traverse the level from the starting point, until you reach the teleportation box that will take you into the next level. To successfully do this, you must avoid or eliminate the enemy units that you, the Runner, will encounter during the level. 

  #### Collectibles
  There are two kinds of collectibles that the Runner can obtain during the course of a level. They are the following: 
  
  <img width="16" alt="image" src="https://user-images.githubusercontent.com/30426576/209906549-2975244a-5f2f-4c55-9479-c67726fd3815.png"> <b>HEART</b> - These hearts represent the player’s “lives” in the game. One heart is one life, and they can be collected at different points during a level. When the player dies from falling off the map or from enemy unit damage, you lose one of your collected hearts. Replenish your “lives” by collecting these hearts!
  
  <img width="16" alt="image" src="https://user-images.githubusercontent.com/30426576/209906638-d0a3a228-4759-467e-833e-76f9e5f7fdcf.png"> <b>DATA DISC</b> - These discs represent the information that the Runner collects and transports for their clients. There is a set amount of discs in a level, but to ascend to the next level, you are not required to collect them all. However, to truly beat the game and succeed with the final level, collecting all data discs is crucial. 

---
### Weapons
The Runner has only one weapon, which is the gun holstered around their waist. Enemy difficulty in this game is determined by how many times you need to shoot an enemy unit before it is eliminated. 

---
### Enemy Units
The following units are the most common types of Security Alpha units the Runner will encounter throughout the game: 

  <img width="56" alt="image" src="https://user-images.githubusercontent.com/30426576/209906723-7a53550d-f329-4dd0-bdec-46e342b6caa7.png">        <b>HUMAN GUARD</b> - The human guard is Security Alpha’s cyborg unit. They are part-human and part-machine, although the ratios of these two elements are not exactly known.  Their walking path involves moving from one point to another, and kills the player upon collision. A human guard has 2 health points (HP), and it takes 2 shots from the player’s weapon to 
eliminate this unit. 

  <img width="38" alt="image" src="https://user-images.githubusercontent.com/30426576/209907219-da637130-57fd-4f09-b540-0027af242d8b.png"> &nbsp; &nbsp;<b>DRONE</b> - The drone is Security Alpha’s flying unit. Unlike the human guard, who travels from one point to another, the drone advances towards the player as soon as they are within a certain vicinity. Fast, agile, unexpected, but easier to kill. It only takes 1 shot from the player’s weapon to eliminate this unit, but challenge is making sure that one shot lands where it needs to go. 
  
  <img width="50" alt="image" src="https://user-images.githubusercontent.com/30426576/209907281-77481682-23e4-4c5f-8559-8d0a11ba49af.png">        <b>BOSS</b> - The final and the most difficult enemy of a Runner. Boss units are the last challenge in every Runner’s data transport. If the Runner has failed to collect all the data discs in the entire game, they cannot defeat these large and imposing units. 

---
### World Objects and People

<img width="53" alt="image" src="https://user-images.githubusercontent.com/30426576/209907750-82c63d40-158c-449b-a8a4-a653863968fc.png"> <b>TELEPORTATION BOX</b> - The teleportation box serves as the level’s exit point. To advance to the next level, one must find the location of the teleportation box. Once found, the player may enter the box to advance to the next level. 

<img width="53" alt="image" src="https://user-images.githubusercontent.com/30426576/209907793-fc8136f9-8579-423b-9b9f-07934efdf622.png"> <b>THE HANDLER</b> - Each Runner in the Nightrunners network is assigned a Handler. A Handler is in charge of making sure all data transports are smooth, successful, and that the Runner makes it out alive. In this game, The Handler is non-interactable NPC that can be seen standing beside the teleportation boxes in each level. 

<img width="55" alt="image" src="https://user-images.githubusercontent.com/30426576/209907839-e8997482-c745-47e1-81a5-74e1a5dba8dd.png"> <b>(YOU) THE RUNNER</b> - The Runner is the character that you, the player, control throughout the game. As a Runner, you collect the data discs that is scattered throughout each level of the game. These discs are part of your job as a data transporter, to stay alive and protecting your cargo (the data) is a crucial part of your job. 

## Controls
In this section, we will briefly explore the gaming interface as well as the basic player controls. The following is an in-game screenshot from the Night City level, the first level, of the game running on a Pixel 2 API 30: 

![image](https://user-images.githubusercontent.com/30426576/209908032-5fa70e62-5621-4410-89c7-f3fd7746ff7f.png)

<b>NAVIGATIONAL BUTTONS</b> - As a Runner in this 2D world, the player is granted mobility in two directions: left and right. Unlike retro platformers where it is often difficult or impossible to walk back once you walk forward, The Nightrunners allows the player to travel from one end to another end as they like. This feature is especially useful on some of the levels later in the game.

<b>DISC COUNTER</b> - Each level has a fixed number of data discs that can be found in that specific level. In the HUD, this information is conveyed through the format (discs collected) / (total number of discs in this level).

<b>JUMP</b> - This action button allows the player to jump in three different ways: jump in place, jump while running forward (right), and jump while running backward (left). The jump forward is higher than the jump backward, which can be quite a challenge if a level requires the player to move back and forth across a level. 

<b>SHOOT</b> - This action button allows the player to fire their weapon. Each press of this button fires a single shot, which removes 1 health point (HP) from an enemy unit that it collides with. To fire multiple shots of your weapon, simply tap this button repeatedly. 

<b>LIFE COUNTER</b> - This part of the HUD shows you, the player, the amount of “lives” you have left in the game. Everytime you lose a life from an altercation with an enemy unit, or by falling off the map, this number decreases by 1. The game is over when this counter reaches 0. To keep it from going to 0, make sure to replenish the counter by collecting the hearts that you find on each level. 

<b>PAUSE</b> - This action button allows the player to pause the game. 

## Lore
In this section, we will focus on the lore of The Nightrunners and the characters, organizations, and the era that bring this world to life. You don’t need to know all of these details to enjoy this game, but nonetheless, it makes for engaging reading to those of you who would like to learn more. 

### The World
The Nightrunners is set in a tech-noir society centuries from our current time. Computers have advanced further, but how about us? We did, in a way, but there is a yearning for the “old ways” — leading to a movement that preserved certain subcultures and elements that should have been long gone. This included styles of dressing, the presence of “old style” buildings existing alongside glass-panelled, modernist architectures. The oldest parts of cities remained the same, save for the holographic projections here and there. 

Advancements, it seems, had a price. A more connected world allowed the establishment of mass surveillance, with the government intercepting every little thing that travels across the web. This move was motivated by a campaign to fight against those who plot against the government’s authority, which slowly evolved into the authorities using this newfound power for something even more sinister and intrusive. Thus, the Nightrunners network was born.

### Nightrunners
An answer — although some may argue is an act of rebellion — to this new normal of mass surveillance. They are an underground network specialising in data transport, with that data being about anything, from just about anyone, and delivered to anyone in the city. Because of this, Runners find themselves traversing many different cities, and manoeuvring through many interesting situations. This required Runners to not only be skilled physically, but also have good marksmanship and a clever head on their shoulders. Data transport is just one part of the job, protecting the data they carry and staying alive are also equally crucial. 

### Security Alpha
Security Alpha is a private security company with a long-term contract with the government. Conditions of this contract include acting as the main and acting police force, thus, making them a threat to any Runner who stumbles onto their path. As enforcers of government law, Runners are seen as the very symbol of defiance to the mass surveillance movement. Composed of units made of man, machine, and the in-between, they are instructed to attack Runners wherever they may dwell and patrol their common routes. Not only have they made data transport more difficult, they have also made it a quite a life-threatening occupation. 

## Acknowledgements
<i>The Nightrunners</i> stands on the shoulders of very talented creators that helped bring this vision to life. Credits to these creators will be found in this section. 

### Game Engine
<i>The Nightrunners</i> is built using the 2D platformer game engine we covered in Unit 3 of John Horton’s Android Game Programming by Example, which is the textbook that we are using for this class. Not only has this been an incredible resource, it also helped me understand how to build a 2D platformer using Java and developing for Android devices. 

### Assets - Drawable 
<i>The Nightrunners</i> uses many assets from talented creators who have granted permission that allow me to do so. The assets are all from creators who have a similar thematical vision and style with each other, and this has helped make <i>The Nightrunners</i> to be visually consistent as much as possible. 

  * <b>[Cyberpunk Street Environment](https://ansimuz.itch.io/cyberpunk-street-environment)</b> - This asset pack is from a creator [ansimuz](https://ansimuz.itch.io/), and a heavily modified version of this asset can be found in the main screen of the game, Night City (first level) of The Nightrunners. The work is protected under [CC0 1.0 Universal (CC0 1.0) Public Domain Dedication](https://creativecommons.org/publicdomain/zero/1.0/) license, which allows me certain rights including using this both for commercial and personal uses. This also allows me to modify the work as I see fit, and hence why it looks very different in the game in compared to the original. 
  * <b>[WARPED Zone 202](https://ansimuz.itch.io/warped-zone-202)</b> - This asset pack is yet another one from [ansimuz](https://ansimuz.itch.io/). This asset can be found in the Military Base (second level) of The Nightrunners. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209911748-1263a874-5554-4bfa-9183-8e0f62c02efd.png"></div>

  * <b>[WARPED Miami Synth](https://ansimuz.itch.io/warped-miami-synth)</b> - This asset pack is also from [ansimuz](https://ansimuz.itch.io/). This asset can be found in the Synth City (third level) of The Nightrunners. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following in the public-license.txt file included in the download: 

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209912264-b83ff2b0-98b0-4c9c-842f-2295c119ae12.png"></div>

  * <b>[Warped Sci-Fi Lab](https://ansimuz.itch.io/warped-sci-fi-lab)</b> - This asset pack is another pack from [ansimuz](https://ansimuz.itch.io/), and unlike Cyberpunk Street environment, this asset was not modified — only enlarged. This asset can be found in the Research Lab (fourth and last level) of The Nightrunners. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209912448-28e057e3-3c74-45cc-98b7-9bc0a45683e5.png"></div>

  * <b>[Free Pixel Art Tiles](https://totuslotus.itch.io/free-pixel-art-tiles)</b> - This asset pack is from the creator [TotusLotus](https://totuslotus.itch.io). The tiles from this asset pack can be found in Night City (first level), Synth City (third level), and Research Lab (fourth level) levels of The Nightrunners. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209912582-50ff168c-46e8-4193-a926-937b2b6953fe.png"></div>

  * <b>[User Interface Icon Pack](https://kazzter-k.itch.io/interface-icons)</b> - This asset pack is from the creator [Kazzter](https://kazzter-k.itch.io). The data disc and the heart symbols come from this asset. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209912828-a8ee79c8-5787-42e7-8d4f-9298f610d371.png"></div>

  * <b>[Cyberpunk Character Pack 2](https://oco.itch.io/cyberpunk-character-pack-2)</b> - This asset pack is from the creator [0c0](https://oco.itch.io). The player’s Runner character as well as the The Handler, both come from this pack. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209913623-9bafd784-d375-45cb-865f-a8fc211110b4.png"></div>

  * <b>[Warped Props Pack 1](https://ansimuz.itch.io/warped-props)</b> - This asset pack is another one from [ansimuz](https://ansimuz.itch.io/). The capsule sprite that represents the teleportation box in the game comes from this pack. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209914441-c484dfd7-b5e4-4e81-a875-2dc99e6fc6e4.png"></div>

  * <b>[Pixel Art Sci-Fi Cyberpunk Police](https://evgeniy-luch.itch.io/pixel-art-sci-fi-cyberpunk-police)</b> - This asset pack is from the creator [Evgeniy Luch](https://evgeniy-luch.itch.io). The drone, the human guard, and the boss all come from this pack. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209914630-696074ea-f6de-4322-a3b0-fcae12069b0a.png"></div>

### Sound

  * <b>[Sci-Fi Sound Effects Asset Pack](https://mattflat.itch.io/sci-fi-space-sound-effects-asset-pack)</b> - This asset pack is from the creator [mattflat](https://mattflat.itch.io). The sound effects for shoot, jump, teleport, obtaining a disc, landing a hit on a human guard, explosion of a drone, and collecting an extra life come from this pack. This work is protected under [Attribution-NoDerivs 3.0 Unported (CC BY-ND 3.0)](https://creativecommons.org/licenses/by-nd/3.0/) license, which allows sharing and distribution of the material as long as the following conditions are fulfilled: 
       * I must give credit to the creator, provide a link to the license, and note any changes.
       * Through the Acknowledgements section and in my source code, I have given credit to the creator. 
       * In this section, I have shared the link of the license page, and as for any changes, no modifications were made.
       * That any derivative works on the material cannot be distributed. 

  * <b>[AI, Cyberdemon, & Alien Sound Effects](https://btl-games.itch.io/ai-cyberdemon-alien-sound-effects)</b> - This asset pack is from the creator [BTL games](https://btl-games.itch.io). The sound effect for player death comes from this pack. This work appears to not have a Creative Commons license attached to its page, however, the creator has explicitly stated the following on the asset’s page:

<div align=center><img width="492" alt="image" src="https://user-images.githubusercontent.com/30426576/209914978-c6e5cb60-38bb-4014-868a-ac92f5a11858.png"></div>
