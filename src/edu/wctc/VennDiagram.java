package edu.wctc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VennDiagram <T> {

    String label1;
    String label2;
    String label3;

    Set<T> set1;
    Set<T> set2;
    Set<T> set3;


    public VennDiagram(String label1, String label2, String label3) {

        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;

        this.set1 = new HashSet<>();
        this.set2 = new HashSet<>();
        this.set3 = new HashSet<>();

    }


    public Set<T> getCircleForLabel(String label) {
        Set<T> set = null;

        if (Objects.equals(label, this.label1))
            set = set1;
        else if (Objects.equals(label, this.label2))
            set = set2;
        else if (Objects.equals(label, this.label3))
            set = set3;
        return set;
    }

    public void add(T item, String... labels) {
        Set<T> set = null;
        for (String label : labels) {
            set = getCircleForLabel(label);
            set.add(item);
        }
    }

    public Set<T> unionOf(String first, String second) {

        Set<T> unionOf = new HashSet<>(getCircleForLabel(first));
        unionOf.addAll(getCircleForLabel(second));

        return unionOf;
    }

    public Set<T> intersectionOf(String first, String second) {

        Set<T> intersectionOf = new HashSet<>(getCircleForLabel(first));
        intersectionOf.retainAll(getCircleForLabel(second));

        return intersectionOf;
    }

    public Set<T> complementOf(String first, String second) {

        Set<T> complementOf = new HashSet<>(getCircleForLabel(first));
        complementOf.removeAll(getCircleForLabel(second));

        return complementOf;
    }

    public Set<T> diagramCenter() {
        Set<T> diagramCenter = new HashSet<>(set1);
        diagramCenter.retainAll(set2);
        diagramCenter.retainAll(set3);

        return diagramCenter;
    }


}


