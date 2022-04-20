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
      &c. and is very fast at mining with good durability, well-rounded but not too much special about it) vs infinitite (which has stronger buffs like flight, but doesnt
      have stuff like onDeathAutoTeleportClutch or anything like that

### Development nicities, modpack support, etc.
- Implement some modular library stuff in a class, like for example maybe a recipe/guide book. Add methods for registering recipes for the fusion table that isn't 
hardcoded, ideas: use GSON to read from files? Maybe port SCON to Java, or use a YAML parser also works

