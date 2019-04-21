import java.util.ArrayList;

public class List<T> {
    private ListElement firstElement;
    private ListElement lastElement;

    public void oneElement(ListElement a) {
        firstElement = a;
        lastElement = a;
    }


    /**
     * add element inFront
     *
     * @param data
     */
    public void addFront(T data) {
        ListElement a = new ListElement();
        a.data = data;
        if (firstElement == null) {
            oneElement(a);
        } else {
            a.next = firstElement;
            firstElement = a;
        }
    }

    /**
     * add eltment in Back
     *
     * @param data
     */
    void addBack(T data) {
        ListElement a = new ListElement();
        a.data = data;
        if (lastElement == null) {
            oneElement(a);
        } else {
            lastElement.next = a;
            lastElement = a;
        }
    }


    /**
     * delete element of list
     *
     * @param data
     */
    public void deleteElement(T data) {
        if (firstElement == null)
            return;

        else if (firstElement == lastElement) {
            firstElement = null;
            lastElement = null;
            return;
        } else if (firstElement.data == data) {
            firstElement = firstElement.next;
            return;
        }

        ListElement t = firstElement;
        while (t.next != null) {
            if (t.next.data == data) {
                if (lastElement == t.next) {
                    lastElement = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }

    /**
     * get link on list
     *
     * @return
     */
    ArrayList<String> List() {
        ArrayList<String> list = new ArrayList<String>();
        ListElement t = firstElement;
        while (t != null) {
            list.add(t.data.toString());
            t = t.next;
        }
        return list;
    }


}
