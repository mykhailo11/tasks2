package main.tasks;

import java.math.BigInteger;

public class Task2 {
    
    private BigInteger stages;
    private BigInteger rooms;
    
    public Task2(BigInteger stages, BigInteger rooms) throws IllegalArgumentException{
        if (stages.compareTo(BigInteger.ZERO) <= 0 || rooms.compareTo(BigInteger.ZERO) <= 0){
            throw new IllegalArgumentException("Numbers of stages and rooms must be greater than zero");
        }
        this.stages = stages;
        this.rooms = rooms;
    }
    public BigInteger getStages(){
        return stages;
    }
    public BigInteger getRooms(){
        return rooms;
    }
    public BigInteger getRoomsInBlock(){
        return stages.multiply(rooms);
    }
    public void setStages(BigInteger stages) throws IllegalArgumentException{
        if (stages.compareTo(BigInteger.ZERO) <= 0){
            throw new IllegalArgumentException("Number of stages must be greater than zero");
        }
        this.stages = stages;
    }
    public void setRooms(BigInteger rooms) throws IllegalArgumentException{
        if (rooms.compareTo(BigInteger.ZERO) <= 0){
            throw new IllegalArgumentException("Number of rooms must be greater than zero");
        }
        this.rooms = rooms;
    }
    public BigInteger getBlock(BigInteger room) throws IllegalArgumentException{
        if (rooms.compareTo(BigInteger.ZERO) <= 0){
            throw new IllegalArgumentException("Room number must be greater than zero");
        }
        return (room.subtract(BigInteger.ONE)).divide(getRoomsInBlock()).add(BigInteger.ONE);
    }
    public BigInteger getStage(BigInteger room) throws IllegalArgumentException{
        if (rooms.compareTo(BigInteger.ZERO) <= 0){
            throw new IllegalArgumentException("Room number must be greater than zero");
        }
        return ((room.subtract(BigInteger.ONE)).mod(getRoomsInBlock())).divide(rooms).add(BigInteger.ONE);
    }
}
