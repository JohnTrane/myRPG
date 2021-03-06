package myrpg.map;

import javafx.util.Pair;
import myrpg.units.Actor;
import myrpg.units.IUnit;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.util.HashMap;


public class Map implements IMap {
    ILocation[][] map;
    BidiMap<ILocation, IUnit> unitsOnLocations = new TreeBidiMap<ILocation, IUnit>();
    HashMap<ILocation, Point> hash = new HashMap<>();

    public Map(int row, int col) {
        this.map = new Location[row][col];
    }

    public BidiMap<ILocation, IUnit> getUnitsOnLocations() {
        return this.unitsOnLocations;
    }

    @Override
    public IUnit getUnitOnPoint(Point point) {
        return null;
    }


    public boolean addUnit(IUnit unit, Point position) {
        ILocation location = map[position.rowPosition][position.colPosition];
        if (unitsOnLocations.containsKey(location))
            return false;
        if (location.hasObstacle())
            return false;

        unitsOnLocations.put(location, unit);
        return true;
    }

    @Override
    public Point getUnitPosition(IUnit unit) {
        ILocation location = unitsOnLocations.getKey(unit);
        return hash.get(location);
    }

    public boolean isAccessibleByUnit(int row, int col) {
        ILocation location = map[row][col];
        return !(location.hasObstacle() || unitsOnLocations.containsKey(location));
    }

//    public boolean removeUnit(IUnit unit, Point position){
//        ILocation location = map[position.rowPosition][position.colPosition];
//       if(unitsOnLocation.get(location).equals(unit)){
//            unitsOnLocation.remove(location);
//        }
//    }

    public boolean removeUnit(IUnit unit) {
        if (unitsOnLocations.containsValue(unit)) {
            unitsOnLocations.remove(unitsOnLocations.getKey(unit));
            return true;
        }
        return false;
    }

    public boolean removeUnit(Point position) {
        ILocation location = map[position.rowPosition][position.colPosition];
        if (unitsOnLocations.containsKey(location)) {
            unitsOnLocations.remove(location);
            return true;
        }
        return false;
    }

    public void generate() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Pair<ILocation, IUnit> locationWithUnit = Location.generateRandomLocation();
                map[i][j] = locationWithUnit.getKey();

                if (locationWithUnit.getValue() != null)
                    unitsOnLocations.put(locationWithUnit.getKey(), locationWithUnit.getValue());

                hash.put(locationWithUnit.getKey(), new Point(j, i));
            }
        }
    }

    public void generateEmptyMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Pair<ILocation, IUnit> locationWithUnit = new Pair<>(new Location(), null);
                map[i][j] = locationWithUnit.getKey();
                hash.put(locationWithUnit.getKey(), new Point(j, i));
            }
        }
    }

    @Override
    public int getHeight() {
        return map.length;
    }

    @Override
    public int getWidth() {
        return map[0].length;
    }

    @Override
    public ILocation getLocation(int col, int row) {
        return map[row][col];
    }

}
