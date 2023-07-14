import psycopg2

# Connect to the database
connection = psycopg2.connect(
    host="your_host",
    database="FreeHousePrd",
    user="your_user",
    password="your_password"
)

def check_capacity(warehouse_id):
    """
    Check if the total size of objects in a warehouse exceeds its capacity.
    Returns True if the capacity is not exceeded, False otherwise.
    """
    with connection.cursor() as cursor:
        # Calculate the sum of sizes * quantities of objects in the warehouse
        cursor.execute("""
            SELECT SUM(t.size * o.quantity)
            FROM WhsObjects o
            JOIN ObjTypes t ON o.TypId = t.TypId
            WHERE o.WhsId = %s
        """, (warehouse_id,))
        total_size = cursor.fetchone()[0]
        
        # Get the capacity of the warehouse
        cursor.execute("""
            SELECT Capacity
            FROM Warehouses
            WHERE WhsId = %s
        """, (warehouse_id,))
        capacity = cursor.fetchone()[0]
    
    if total_size is None:
        total_size = 0
    
    # Check if the total size exceeds the capacity
    if total_size > capacity:
        return False
    else:
        return True

def add_object(warehouse_id, type_id, quantity):
    """
    Add an object to a warehouse.
    Returns True if the object was added successfully, False otherwise.
    """
    # Check if adding the object exceeds the warehouse's capacity
    if not check_capacity(warehouse_id):
        return False
    
    with connection.cursor() as cursor:
        # Insert the object into the WhsObjects table
        cursor.execute("""
            INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
            VALUES (%s, %s, %s, 'user', NOW())
        """, (warehouse_id, type_id, quantity))
    
    connection.commit()
    return True

def update_object(warehouse_id, type_id, quantity):
    """
    Update the quantity of an object in a warehouse.
    Returns True if the object was updated successfully, False otherwise.
    """
    # Check if updating the object exceeds the warehouse's capacity
    if not check_capacity(warehouse_id):
        return False
    
    with connection.cursor() as cursor:
        # Update the quantity of the object in the WhsObjects table
        cursor.execute("""
            UPDATE WhsObjects
            SET Quantity = %s
            WHERE WhsId = %s AND TypId = %s
        """, (quantity, warehouse_id, type_id))
    
    connection.commit()
    return True

# Example usage:

# Add an object to warehouse 1
add_object(1, 6, 5)

# Update the quantity of an object in warehouse 2
update_object(2, 1, 8)

# Close the database connection
connection.close()