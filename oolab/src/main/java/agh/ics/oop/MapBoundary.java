package agh.ics.oop;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    public Comparator<IMapElement> myCompX =Comparator.comparing((IMapElement x) -> x.getPosition().x).thenComparing((IMapElement y) -> y.getPosition().y).thenComparing(IMapElement::toString);
    public SortedSet<IMapElement> MyX = new TreeSet<>(myCompX);
    public Comparator<IMapElement> myCompY =Comparator.comparing((IMapElement y) -> y.getPosition().y).thenComparing((IMapElement x) -> x.getPosition().x).thenComparing(IMapElement::toString);
    public SortedSet<IMapElement> MyY = new TreeSet<>(myCompY);
    public void add(IMapElement element){
        MyX.add(element);
        MyY.add(element);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Iterator<IMapElement> itr = MyX.iterator();
        while (itr.hasNext()) {
            if(itr.next().getPosition().equals(newPosition) && !itr.next().toString().equals("*")){
                IMapElement object = itr.next();
                MyX.remove(object);
                MyY.remove(object);
                MyX.add(object);
                MyY.add(object);
                break;
            };
        }
    }
}