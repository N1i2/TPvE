package org.example.exp1;

public class People {
    public People() {
    }

    public People(String name, int vote) {
        this.Name = name;
        this.Vote = vote;
    }

    public String Name;
    public int Vote;
    public int AllVote;

    public int getAllVote() {
        return AllVote;
    }

    public void setAllVote(int allVote) {
        AllVote = allVote;
    }

    public int getVote() {
        return Vote;
    }

    public void setVote(int vote) {
        Vote = vote;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
}
