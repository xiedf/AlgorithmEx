package QueenAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class QueenOfDogAndCat{
    Queue<PetEnterQueue> dogQueue;
    Queue<PetEnterQueue> catQueue;
    private long count;

    public QueenOfDogAndCat(){
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if (pet.getPetType().equals("dog")) {
            this.dogQueue.add(new PetEnterQueue(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll(){
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            if (this.dogQueue.peek().getcount() < this.catQueue.peek().getcount()){
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();
        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is empty");
        }

    }

    public Dog pollDog(){
        if (!this.dogQueue.isEmpty()) {
            return (Dog)dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }

    }

    public Cat pollCat(){
        if (!this.catQueue.isEmpty()) {
            return (Cat)catQueue.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty(){
        return (dogQueue.isEmpty() && catQueue.isEmpty());
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }
}

class PetEnterQueue{
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getcount() {
        return this.count;
    }

    public String getEnterType(){
        return this.pet.getPetType();
    }
}

class Pet {
    private String type;
    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}