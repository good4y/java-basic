package chap10.genericsextra.extrachallenge.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<LPAStudent> {
    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}
