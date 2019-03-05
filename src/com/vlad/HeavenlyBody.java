package com.vlad;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    //private final int bodyType;                //also need to change this in here for enum
    private final BodyTypes bodyType;
    //Instead of having different declarations for each define an enum
  /*  public static final int STAR = 1;
    public static final int PLANET = 2;
    public static final int DWARF_PLANET = 3;
    public static final int MOON = 4;
    public static final int COMET = 5;
    public static final int ASTEROID = 6; */
    public enum BodyTypes{
         PLANET,
         DWARF_PLANET,
         MOON,
         COMET,
         ASTEROID
    }
    //also for enum add here in constructor BodyTypes
    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    //add for challenge
    public BodyTypes getBodyType() {
        return bodyType;
    }
    //refactor for challenge
    public boolean addSatellite(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj){                    //add final here for challenge
        if(this == obj){
            return true;
        }
        //don't need this for challenge
        /*System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }*/

        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if(this.name.equals(theObject.getName())){
                return this.bodyType == theObject.getBodyType();
            }
        }
        return false;

        /*String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);*/

    }

    @Override
    public final int hashCode() {                         //here also add final for challenge and change code
       /* System.out.println("hashcode called");
        return this.name.hashCode() + 57; */
       return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }
    //add this for challenge
    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
