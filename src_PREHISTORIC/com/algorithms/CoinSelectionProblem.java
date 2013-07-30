// http://stackoverflow.com/questions/13751572/dynamic-programming-optimal-coin-change

def dpMakeChange(coinValueList,change,minCoins):
   # Solve the problem for each number of cents less than the target
   for cents in range(change+1):

      # At worst, it takes all pennies, so make that the base solution
      coinCount = cents

      # Try all coin values less than the current number of cents
      for j in [c for c in coinValueList if c <= cents]:

            # See if a solution to current number of cents minus the value
            # of the current coin, with one more coin added is the best 
            # solution so far  
            if minCoins[cents-j] + 1 < coinCount:
               coinCount = minCoins[cents-j]+1

      # Memoize the solution for the current number of cents
      minCoins[cents] = coinCount

   # By the time we're here, we've built the solution to the overall problem, 
   # so return it
   return minCoins[change]