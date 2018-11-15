package group01_0mperson;

public class Person {
	private String name;
	// association --> 0..1 Group
	private Group group; //nullable

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	// -------------------------------------------------------------------------

	/** Note: nullable return value. */
	public Group getGroup() {
		return group;
	}

	/**
	 * Sets the group as this person's group,
	 * if they aren't connected.
	 * Pre: This person isn't connected to another group.
	 */
	public void setGroup(Group group) {
		if (this.group != group) {
			Pre.require(this.group == null);
			this.group = group;
			group.addPerson(this);
		}
	}

	/**
	 * Clears this person's group.
	 */
	public void setGroupNull() {
		if (this.group != null) {
			Group oldGroup = this.group;
			this.group = null;
			oldGroup.removePerson(this);
		}
	}
}
