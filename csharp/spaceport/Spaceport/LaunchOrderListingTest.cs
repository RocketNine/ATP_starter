using NUnit.Framework;

namespace SpacePort
{
    [TestFixture]
    public class LaunchOrderListingTest
    {
        
        //TODO - Use the Stub Recipe to test that launches are sorted correctly
        [Test]
        public void LaunchesAreSortedByDestination_DestinationsAreUnique()
        {
            // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)

            // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection,
            // Exercising this behavior happens during construction of the System Under Test

            // Step 5. Verify the results are sorted correctly
            Assert.Fail("TODO - test the launch info sorting behavior");
        }
    }
}