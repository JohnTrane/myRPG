package myrpg.units.classes;

import myrpg.units.MovementType;

public class Warrior implements IClass {


    private String className = "Warrior";

    public Warrior() {
    }

    @Override
    public int getBaseHp() {
        return 25;
    }

    @Override
    public int getBaseArmor() {
        return 8;
    }

    @Override
    public int getBaseAttack() {
        return 9;
    }

    @Override
    public int getBaseMagicAttack() {
        return 0;
    }

    @Override
    public int getBaseMagicalResistance() {
        return 0;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public int getRange() {
        return 1;
    }

    @Override
    public AttackType getAttackType() {
        return AttackType.meleePhysicalDamage;
    }

    @Override
    public MovementType getMovementType() {
        return MovementType.foot;
    }
}
