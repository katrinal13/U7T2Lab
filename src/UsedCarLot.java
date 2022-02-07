import java.util.ArrayList;

/**
 * This class represents a UsedCarLot object
 *
 * @author Katrina Lin
 */
public class UsedCarLot
{
    /** The inventory of Car objects */
    private ArrayList<Car> inventory;

    /**
     * Instantiates a UsedCarLot object
     */
    public UsedCarLot()
    {
        inventory = new ArrayList<Car>();
    }

    /**
     * Returns the inventory of Car objects
     *
     * @return The inventory of Car objects
     */
    public ArrayList<Car> getInventory()
    {
        return inventory;
    }

    /**
     * Adds the given Car object to the inventory
     *
     * @param addCar The new Car object
     */
    public void addCar(Car addCar)
    {
        inventory.add(addCar);
    }

    /**
     * Returns true if the swap of the Car objects at the corresponding indices was successful; returns false otherwise
     *
     * @param indice1 The index of the first car to swap
     * @param indice2 The index of the second car to swap
     *
     * @return true or false depending on whether or not the swap was successful
     */
    public boolean swap(int indice1, int indice2)
    {
        if (indice1 < 0 || indice1 > inventory.size() - 1 || indice2 < 0 || indice2 > inventory.size() - 1)
        {
            return false;
        }
        else
        {
            Car tempCar = inventory.get(indice1);
            inventory.set(indice1, inventory.get(indice2));
            inventory.set(indice2, tempCar);

            return true;
        }
    }

    /**
     * Adds a Car to the inventory list at the index specified by indexToAdd
     * <p>
     * PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     *
     * @param indexToAdd The desired index for the Car object to be added at
     * @param carToAdd The Car object to be added
     */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        inventory.add(indexToAdd, carToAdd);
    }

    /**
     * "sells" the Car located at indexOfCarToSell which removes it from the inventory list
     * <p>
     * Removes it from the inventory list and shifts the remaining Cars in the inventory to the left to fill the gap and reduces the size of inventory by 1
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the Car object to be removed from the inventory
     * @return The Car object that was removed from the inventory
     */
    public Car sellCarShift(int indexOfCarToSell)
    {
        Car removed = inventory.remove(indexOfCarToSell);
        return removed;
    }

    /**
     * "sells" the Car located at indexOfCarToSell, REPLACES the Car at indexOfCarToSell with NULL
     * <p>
     * Creates an "empty parking spot" on the lot and maintains the size of the inventory
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     *
     * @param indexOfCarToSell The index of the Car object to be sold and replaced will NULL
     * @return The Car object modified to NULL from the inventory
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car removed = inventory.set(indexOfCarToSell, null);
        return removed;
    }

    /**
     * Moves Car located at index indexOfCarToMove to index destinationIndex
     * <p>
     * If destinationIndex > indexOfCarToMove, moves the Car to right in inventory
     * <p>
     * If destinationIndex &lt; indexOfCarToMove, moves the Cars to the left in the inventory
     * All other cars in the inventory shift accordingly
     * <p>
     * PRECONDITIONS: indexOfCarToMove &lt; inventory.size()
     * <p>
     *                destinationIndex &lt; inventory.size()
     *
     * @param indexOfCarToMove The index of the Car object that will be moved
     * @param destinationIndex The destination index at which the Car object will be moved to
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        Car temp = inventory.remove(indexOfCarToMove);
        addCar(destinationIndex, temp);
    }
}
