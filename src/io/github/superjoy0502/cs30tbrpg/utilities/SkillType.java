package io.github.superjoy0502.cs30tbrpg.utilities;

public enum SkillType {
    ACCOUNTING("Accounting"),
    ACTING("Acting"),
    ANIMAL_HANDLING("Animal Handling"),
    ANTRHROPOLOGY("Anthropology"),
    APPRAISE("Appraise"),
    ARCHAEOLOGY("Archaeology"),
    ARTILLERY("Artillery"),
    ASTRONOMY("Astronomy"),
    AXE("Axe"),
    BIOLOGY("Biology"),
    BOTANY("Botany"),
    BOW("Bow"),
    BRAWL("Brawl"),
    CHAINSAW("Chainsaw"),
    CHARM("Charm"),
    CHEMISTRY("Chemistry"),
    CLIMB("Climb"),
    COMPUTER_USE("Computer Use"),
    CREDIT_RATING("Credit Rating"),
    CRYPTOGRAPHY("Cryptography"),
    CTHULHU_MYTHOS("Cthulhu Mythos"),
    DEMOLITIONS("Demolitions"),
    DISGUISE("Disguise"),
    DIVING("Diving"),
    DODGE("Dodge"),
    DRIVE_AUTO("Drive Auto"),
    ELECTRICAL_REPAIR("Electrical Repair"),
    ELECTRONICS("Electronics"),
    FAST_TALK("Fast Talk"),
    FINE_ART("Fine Art"),
    FIRST_AID("First Aid"),
    FLAIL("Flail"),
    FLAME_THROWER("Flame Thrower"),
    FORENSICS("Forensics"),
    FORGERY("Forgery"),
    GARROTTE("Garrotte"),
    GEOLOGY("Geology"),
    HANDGUN("Handgun"),
    HEAVY_WEAPONS("Heavy Weapons"),
    HISTORY("History"),
    HYPNOSIS("Hypnosis"),
    INTIMIDATE("Intimidate"),
    JUMP("Jump"),
    LANGUAGE_OTHER("Language (Other)"),
    LANGUAGE_OWN("Language (Own)"),
    LAW("Law"),
    LIBRARY_USE("Library Use"),
    LISTEN("Listen"),
    LOCKSMITH("Locksmith"),
    LORE("Lore"),
    MACHINE_GUN("Machine Gun"),
    MATHEMATICS("Mathematics"),
    MECHANICAL_REPAIR("Mechanical Repair"),
    MEDICINE("Medicine"),
    METEOROLOGY("Meteorology"),
    NATURAL_WORLD("Natural World"),
    NAVIGATE("Navigate"),
    OCCULT("Occult"),
    OPERATE_HEAVY_MACHINERY("Operate Heavy Machinery"),
    PERSUADE("Persuade"),
    PILOT("Pilot"),
    PSYCHOANALYSIS("Psychoanalysis"),
    PSYCHOLOGY("Psychology"),
    READ_LIPS("Read Lips"),
    RIDE("Ride"),
    RIFLE_SHOTGUN("Rifle/Shotgun"),
    SLEIGHT_OF_HAND("Sleight of Hand"),
    SPEAR("Spear"),
    SPOT_HIDDEN("Spot Hidden"),
    STEALTH("Stealth"),
    SUBMACHINE_GUN("Submachine Gun"),
    SURVIVAL("Survival"),
    SWORD("Sword"),
    SWIM("Swim"),
    THROW("Throw"),
    TRACK("Track"),
    WHIP("Whip"),
    ZOOLOGY("Zoology");

    private final String text;

    SkillType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static SkillType fromString(String text) {
        /*// Linear search
        for (SkillType type : SkillType.values()) {
            if (type.text.equalsIgnoreCase(text)) {
                return type;
            }
        }*/

        // Binary search, because it's sorted
        int low = 0;
        int high = values().length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = values()[mid].text.compareTo(text);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return values()[mid];
            }
        }
        return null;
    }
}
