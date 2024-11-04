package pij.day11.cashRegister;

/**
 * A CashRegister can add items to a sale, undo such additions, and
 * state how many items are on the current sake. It can also complete
 * a sale, be queried for how many sales have been finished, and be
 * queried for the amount spent on completed sales. All monetary
 * quantities are integer values in Pence.
 */
public class CashRegister {

    /**
     * Initialises a new CashRegister without any prior items and sales.
     */
    public CashRegister() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Adds an item to the current sale.
     *
     * @param priceInPence the item's price
     * @throws IllegalArgumentException if priceInPence is -1 or less
     */
    public void addItem(int priceInPence) {
        // TODO Auto-generated method stub
    }

    /**
     * Adds all items in the method parameter to the current sale.
     *
     * @param pricesInPence contains the items to be added
     * @throws NullPointerException if pricesInPence is the null reference
     * @throws IllegalArgumentException if pricesInPence contains a value that
     *  is -1 or less
     */
    public void addItems(int[] pricesInPence) {
        // TODO Auto-generated method stub
    }

    /**
     * Returns the number of items in the current sale.
     *
     * @return the number of items in the current sale.
     */
    public int numberOfItemsInCurrentSale() {
        return 0; // TODO Auto-generated method stub
    }

    /**
     * Returns the total amount in pence of the currently happening sale.
     *
     * @return the total amount in pence of the currently happening sale
     */
    public int getTotalAmountInPenceCurrentSale() {
        return 0; // TODO Auto-generated method stub
    }

    /**
     * Removes the last added item from the current sale if there is such
     * an item. Also in case items were added via the addItems(int[])
     * method, only a single item is removed. Does not modify the object
     * state if there is no item to remove from the current sale. Does
     * not affect previous sales.
     *
     * @return whether an item was removed
     */
    public boolean undo() {
        return false; // TODO Auto-generated method stub
    }

    /**
     * Completes the current sale and starts a new sale.
     *
     * @return the amount from the completed sale
     */
    public int completeSale() {
        return 0; // TODO Auto-generated method stub
    }

    /**
     * Returns the number of sales completed so far.
     *
     * @return the number of sales completed so far
     */
    public int getNumberOfCompletedSales() {
        return 0; // TODO Auto-generated method stub
    }

    /**
     * Returns the total amount in pence of the completed sales.
     * Since the current sale can still be undone, it is not
     * considered by this method.
     *
     * @return the total amount in pence of the completed sales
     *  (but excludes the current incomplete sale)
     */
    public int getTotalAmountInPenceOfCompletedSales() {
        return 0; // TODO Auto-generated method stub
    }
}
