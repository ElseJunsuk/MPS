package com.anotherspectrum.smps.api.item;

public interface Skill {

    // GETTERS

    // Register skill...

    Integer getCooldown();

    /**
     * 재사용 대기시간 감소 효과를 받고 있다면, 얼마나 받고 있는지 확인합니다.
     *
     * @return 재사용 대기시간 감소 시간
     */
    Integer getRedownTime();

    // SETTERS

    Skill setCooldown(Integer time);

    /**
     * 재사용 대기시간 감소 효과를 부여합니다.
     *
     * @param time 재사용 대기시간 감소 부여 시간
     * @return {@link Skill}
     */
    Skill setRedownTime(Integer time);

    Skill setEffect(SkillEffectHandler effects);
    Skill setEffect(SkillEffectHandler... effects);

    // EFFECTOR

    class SkillEffectHandler {

        private double x;
        private double y;
        private double z;

        private double distance;

        public SkillEffectHandler(double x, double y, double z, double distance) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public double getDistance() {
            return distance;
        }
    }

}
