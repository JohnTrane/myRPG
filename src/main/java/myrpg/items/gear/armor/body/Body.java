package myrpg.items.gear.armor.body;

import myrpg.effects.IEffect;
import myrpg.items.gear.armor.Armor;
import myrpg.items.gear.armor.ArmorMaterial;
import myrpg.items.gear.GearSlotType;
import myrpg.items.gear.armor.ArmorSlots;

import java.util.ArrayList;
import java.util.List;

public class Body extends Armor {
    static List<GearSlotType> possibleSlots = new ArrayList<>();

    static {
        possibleSlots.add(GearSlotType.body);
    }

    public Body(ArmorMaterial armorMaterial, String itemName, int itemLevel, List<IEffect> IEffectList) {
        super(ArmorSlots.body, armorMaterial, itemName, itemLevel, false, IEffectList);
    }

    @Override
    public List<GearSlotType> getPossibleSlots(){
        return this.possibleSlots;
    }

}
