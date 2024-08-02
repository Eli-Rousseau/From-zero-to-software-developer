package com.codewithmosh.composite;

public class Demo {
  public static void main(String[] args) {
    var team1 = new Team();
    team1.add(new HumanResource());
    team1.add(new HumanResource());
    team1.add(new Truck());

    var team2 = new Team();
    team2.add(new HumanResource());
    team2.add(new HumanResource());
    team2.add(new Truck());

    var team3 = new Team();
    team3.add(team1);
    team3.add(team2);

    team3.deploy();
  }
}
