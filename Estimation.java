public class Estimation
{
    public static void main(String[] args)
    {
        // Implement code from estimate function
        estimate();
    }

    public static void estimate()
    {
        int numerator = 0;
        int denominator = 0;
        boolean firstValue = true;
        int runCount = 0;

        for (int d = 1; d <= 999; d++)
        {
            for (int n = d * 3; n <= 999; n++)
            {
                double fraction = (double) n / d;

                double estimate = Math.round((fraction - Math.PI)*Math.pow(10, 8)) / Math.pow(10, 8);

                if (firstValue)
                {
                    numerator = n;
                    denominator = d;
                    firstValue = false;
                }
                else if (Math.abs(estimate-0.00000003) < Math.abs(Math.round(((double) numerator / denominator - Math.PI)*Math.pow(10, 8)) / Math.pow(10, 8) - 0.00000003))
                {
                    numerator = n;
                    denominator = d;
                }
                runCount++;
            }
        }
        System.out.println("Total runs: " + runCount);
        System.out.println("The fraction is " + numerator + "/" + denominator);
        System.out.println("The value is " + (double) numerator / denominator);
    }
}