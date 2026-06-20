local current_stock = redis.call('GET', KEYS[1])
if not current_stock then
    return 0
end
-- Step 3: Convert the string response to a number
current_stock = tonumber(current_stock)
-- Step 4: Check if we have stock available
if current_stock > 0 then
    -- Step 5: Decrement the stock in Redis by 1
    redis.call('DECR', KEYS[1])
    -- Return 1 to tell Spring Boot the purchase was successful
    return 1
else
    -- Return 0 to tell Spring Boot it is out of stock
    return 0
end