package seedu.fridgefriend.command;

import java.util.List;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to add a food item into the Fridge.
 * When calling constructor, foodName, category, expiryDate, and location are necessary fields
 */
public class AddCommand extends Command {

    private final Food foodToAdd;

    public AddCommand(String foodName, FoodCategory category, String expiryString,
            FoodStorageLocation location) throws InvalidDateException {
        this.foodToAdd = new Food(category, foodName, expiryString, location);
    }

    @Override
    public void execute() {
        addFood();
        showResults();
    }

    private void addFood() {
        Fridge.add(foodToAdd);
    }

    private void showResults() {
        String message = "Great! I have added "
                + foodToAdd.getFoodName()
                + " into your fridge.\n"
                + "Details: "
                + foodToAdd.toString();
        Ui.printMessage(message);
    }

}
