private static void testSearchCountries() {

    LOGGER.info("Start");

    LOGGER.debug("{}", countryService.searchCountries("ou"));

    LOGGER.info("End");
}

private static void testSearchCountriesSorted() {

    LOGGER.info("Start");

    LOGGER.debug("{}", countryService.searchCountriesSorted("ou"));

    LOGGER.info("End");
}

private static void testCountriesStartingWith() {

    LOGGER.info("Start");

    LOGGER.debug("{}", countryService.getCountriesStartingWith("Z"));

    LOGGER.info("End");
}