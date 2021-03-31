package AdjustableSkillThresholds;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;

@SuppressWarnings("unused")
public class AdjustableSkillThresholdsModPlugin extends BaseModPlugin {
    private static final String FIGHTER_BAYS_THRESHOLD = "carrier_group_fighter_uplink_fighter_bay_threshold";
    private static final String CREW_TRAINING_FLUX_REGULATION_OP = "crew_training_flux_regulation_op_threshold";
    private static final String WEAPONS_DRILLS_OP = "weapon_drills_op_threshold";
    private static final String CONTAINMENT_PROCEDURES_FIELD_REPAIRS_OP = "containment_procedures_field_repairs_op_threshold";
    private static final String AUXILIARY_SUPPORT_OP = "auxiliary_support_op_threshold";
    private static final String PHASE_CORPS_OP = "phase_corps_op_threshold";
    private static final String AUTOMATED_SHIPS_OP = "automated_ships_op_threshold";

    private int getSettingsInt(String key) {
        int value = Global.getSettings().getInt(key); // throws if not convertible to number
        if (value <= 0) {
            throw new RuntimeException(key + " must be bigger than zero");
        }
        return value;
    }

    @Override
    public void onApplicationLoad() {
        BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = getSettingsInt(FIGHTER_BAYS_THRESHOLD);
        BaseSkillEffectDescription.OP_THRESHOLD = getSettingsInt(CREW_TRAINING_FLUX_REGULATION_OP);
        BaseSkillEffectDescription.OP_LOW_THRESHOLD = getSettingsInt(WEAPONS_DRILLS_OP);
        BaseSkillEffectDescription.OP_ALL_LOW_THRESHOLD = getSettingsInt(CONTAINMENT_PROCEDURES_FIELD_REPAIRS_OP);
        BaseSkillEffectDescription.MILITARIZED_OP_THRESHOLD = getSettingsInt(AUXILIARY_SUPPORT_OP);
        BaseSkillEffectDescription.PHASE_OP_THRESHOLD = getSettingsInt(PHASE_CORPS_OP);
        BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = getSettingsInt(AUTOMATED_SHIPS_OP);
    }
}