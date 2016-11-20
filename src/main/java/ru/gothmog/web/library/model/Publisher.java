package ru.gothmog.web.library.beans;

/**
 * Created by gothmog on 21.09.2016.
 */
public class Publisher {
    private long id;
    private String fullName;

    public Publisher() {
    }

    public Publisher(String fullName) {
        this.fullName = fullName;
    }

    public Publisher(long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        if (getId() != publisher.getId()) return false;
        return getFullName() != null ? getFullName().equals(publisher.getFullName()) : publisher.getFullName() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
