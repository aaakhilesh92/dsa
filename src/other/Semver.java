package other;

import java.util.Objects;

public class Semver implements Comparable<Semver> {

    private int majorVersion;
    private int minorVersion;
    private String patchVersion;

    public Semver() {
    }

    public Semver(int majorVersion, int minorVersion, String patchVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.patchVersion = patchVersion;
    }

    public Semver(int majorVersion, int minorVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.patchVersion = "0";
    }

    public Semver(int majorVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = 0;
        this.patchVersion = "0";
    }

    public boolean greaterThan(Semver v2) {
        return this.compareTo(v2) > 0;
    }

    public boolean greaterThanOrEqualTo(Semver v2) {
        return this.compareTo(v2) >= 0;
    }

    public boolean lessThan(Semver v2) {
        return this.compareTo(v2) < 0;
    }

    public boolean lessThanOrEqualTo(Semver v2) {
        return this.compareTo(v2) <= 0;
    }

    @Override
    public int compareTo(final Semver semver) {
        if (Objects.nonNull(semver)) {
            if (this.getMajorVersion() > semver.getMajorVersion()) {
                return 1;
            } else if (this.getMajorVersion() < semver.getMajorVersion()) {
                return -1;
            } else {
                if (this.getMinorVersion() > semver.getMinorVersion()) {
                    return 1;
                } else if (this.getMinorVersion() < semver.getMinorVersion()) {
                    return -1;
                } else {
                    return this.getPatchVersion().compareTo(semver.getPatchVersion());
                }
            }
        } else {
            throw new IllegalArgumentException("version is not passed");
        }

    }

    public String semverToString() {
        return majorVersion + "." + minorVersion + "." + patchVersion;
    }

    @Override
    public String toString() {
        return "Semver{" + "majorVersion=" + majorVersion + ", minorVersion=" + minorVersion + ", patchVersion=" + patchVersion + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Semver semver = (Semver) o;
        return getMajorVersion() == semver.getMajorVersion() && getMinorVersion() == semver.getMinorVersion()
                && getPatchVersion().equals(semver.getPatchVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMajorVersion(), getMinorVersion(), getPatchVersion());
    }

    /**
     * Getter method for property <tt>majorVersion</tt>. * * @return property value of majorVersion
     */
    public int getMajorVersion() {
        return majorVersion;
    }

    /**
     * Setter method for property <tt>majorVersion</tt>.
     *
     * @param majorVersion
     *            value to be assigned to property majorVersion
     */
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    /**
     * Getter method for property <tt>minorVersion</tt>. * * @return property value of minorVersion
     */
    public int getMinorVersion() {
        return minorVersion;
    }

    /**
     * Setter method for property <tt>minorVersion</tt>.
     *
     * @param minorVersion
     *            value to be assigned to property minorVersion
     */
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    /**
     * Getter method for property <tt>patchVersion</tt>. * * @return property value of patchVersion
     */
    public String getPatchVersion() {
        return patchVersion;
    }

    /**
     * Setter method for property <tt>patchVersion</tt>.
     *
     * @param patchVersion
     *            value to be assigned to property patchVersion
     */
    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }
}
