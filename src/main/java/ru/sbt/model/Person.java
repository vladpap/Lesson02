package ru.sbt.model;

public class Person {


    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(String name, boolean man) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    @Override
    public String toString() {

        if (this.spouse == null) {
            return this.name + ((this.man) ? " холост." : " не замужем.");
        } else {
            return this.name + ((this.man) ? " женат на " : " замужем за ") + this.spouse.getName() + ".";
        }
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * <p>
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife,
     * false otherwise
     */
    public boolean marry(Person person) {

        if ((person != null) && (person.isMan() != this.man) && (this.spouse != person)) {
            if (this.spouse != null) {
                divorseSpouse(this.spouse);
            }
            this.spouse = person;
            if (person.spouse != null) {
                divorseSpouse(person.spouse);
            }
            person.spouse = this;

            return true;
        } else {
            return false;
        }

    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse == null) {
            return false;
        }
        divorseSpouse(this.spouse);
        this.spouse = null;
        return true;
    }

    /**
     * Set person.spouse = null
     *
     * @param person
     */
    private void divorseSpouse(Person person) {
        person.spouse = null;
    }
}
