package other;

import java.util.regex.Pattern;

//import org.apache.commons.lang3.StringUtils;

/*
public class SemverHelper {

    private static Pattern pattern = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)$");

    /**
     * Given a string, this function will check if the passed string is a valid semver or not. Not a
     * valid Semver -> return null Valid Semver -> Semver
     * 
     * @param version
     *            version
     * @return null or Semver

    public static Semver getFromValue(String version) {
        Semver semver = new Semver();
        if (isValidSemverVersion(version)) {
            String[] versions = version.split("\\.");
            if (versions.length == 3) {
                semver.setMajorVersion(Integer.parseInt(versions[0]));
                semver.setMinorVersion(Integer.parseInt(versions[1]));
                semver.setPatchVersion(versions[2]);
                return semver;
            }
        }
        return null;
    }

    /**
     * Return whether a String passed is a valid semver or not.
     * 
     * @param version
     *            version
     * @return boolean whether valid semver or not

    public static boolean isValidSemverVersion(String version) {
        return StringUtils.isNotBlank(version) && pattern.matcher(version).matches();
    }

    public static boolean checkIfEqual(Semver obj1, Semver obj2, boolean allowNull) {
        if (allowNull && obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        inRage("9.20.12");
        inRage("11.10.19");
    }

    public static void inRage(String appVersion) {
        String appVersionMin = "9.20.123";
        String appVersionMax = "11.10.9";

        Semver minVersion = SemverHelper.getFromValue(appVersionMin);
        Semver maxVersion = SemverHelper.getFromValue(appVersionMax);
        Semver version = SemverHelper.getFromValue(appVersion);
        boolean b1 = minVersion.compareTo(version) <= 0;
        boolean b2 = maxVersion.compareTo(version) >= 0;
        if (b1 && b2) {
            System.out.println("appVersion " + appVersion + " is in range of " + appVersionMin + " and " + appVersionMax);
        } else {
            if (!b1) {
                System.out.print("appVersion " + appVersion + " is in not range of " + appVersionMin + " and " + appVersionMax);
                System.out.println(". It is out range due to minAppVersion " + appVersionMin);
            } else {
                System.out.print("appVersion " + appVersion + " is in not range of " + appVersionMin + " and " + appVersionMax);
                System.out.println(". It is out range due to maxAppVersion " + appVersionMax);
            }
        }
    }
}

*/