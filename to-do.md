# To-do List
## Categorized. Each category in order of importance
### Gameplay/Features
- Implement fusion table so the pocket star has a use
- Implement endium
- Implement teleportation using Minecraft's waaaaaay more trivial raytraceblock builtins instead of trying (and failing) to stealing chorus fruit code
  - Rollback changes to prior to commit that ads the broken wand? It doesn't work too well so I'll redo it (maybe just delete code and starting over would work better)
- Implement infinitite
  - Tiers need to be done
    - Tier 1: basic, depleted
    - Tier 2: Enhanced (charge through Fusion table with possibly some sort of magic medium? Idea maybe implement some features from Construmentum here since 
      the two mods might work together well (both of them use magic, making you use constramentum soul magic to charge enhanced tools would allow a reasonable 2nd tier)
    - Make sure to balance it with other toolsets (for example, Endium gets special buffs (teleport items direct to inventory to antiburn and stuff like that, maybe
      reach buffs when wearing a full set? teleportation clutch on near-death circumstances) vs Victorium getting different buffs (lots of fortune, good for pickaxes
      &c. and is very fast at mining with good durability, well-rounded but not too much special about it))
      Possibly do: Flight, Regeneration, Strength? Come up with a unique nerf to make infinitite not too powerful

### Development nicities, modpack support, etc.
- Implement some modular library stuff in a class, like for example maybe a recipe/guide book
- Add methods for registering recipes for the fusion table that isn't 
hardcoded, ideas: use GSON to read from files? Maybe port SCON to Java, or use a YAML parser also works

### Ideas: 
- Pocket star items (e.g. scythe with explosive projectiles, shield with explosive knockback)
- Pocket star upgrade to victorium
  - Uses durability while in item
    - Explodes after durability is out unless taken out and regenerated
  - More while item is being used (such as mining/hitting)
- Better beacon?
  - For ideas see Cyclic's Pharos Beacon, a block that consumes potions to distribute their effects as beacon effects... Something unique would be better, but the 
    general idea is similar; Instead of using a beacon as the core you build a multiblock machine that uses a pocket star in the center to distribute buffs in a manner
    similar to how a regular beacon works but with possibly increased range or flexibility (maybe also remove the "needs to see the sky" requirement, since it doesn't
    need to be able to see the sun if it has a tiny star inside of itself already)
- Jetback/rocket boots
- Possibly the pocket star is a magic item
- Or a power source, like mekanism, can power furnaces, redstone, etc for a really long time (see durability & durability/tick) before exploding/etc
- Solar core multiblock
  - Add cabling system for the solar core to power things
  - Figure out how to animate models
  - Add an intake, pump in liquid hydrogen to catalyze pocket star and make it produce more power
    - while star is being fed, regenerate the durability of the star so that if it is removed into a canister the durability is more
- remove the crafting recipe for the star and instead make you build a multiblock to create one (maybe if you build a solar core, then you can provide hydrogen or smth
  and a nether star as the seed and the core will start to create a pocket star (start it from 0 durability, the longer you run it for the larger the durability is)
- Add a crafting recipe for a Star Containment Cell or something like that that allows you to take a star and store it in an inventory slot
