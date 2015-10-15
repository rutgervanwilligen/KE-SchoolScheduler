package sss.reasoner;

import sss.scheduler.objects.*;
import sss.scheduler.properties.Availability;
import sss.reasoner.penaltyObjects.*;

/**
 * Rule base used to optimize a schedule.
 */
  class Jeops_RuleBase_ScheduleOptimizationKB extends jeops.AbstractRuleBase {

	/**
	 * Rules for Teachers
	 */
/* Move a lesson for another lesson for which a teacher has to walk between hours.
Also move the lesson for which a teacher has to walk to a classroom where this is not the case. */
  
    /**
     * Identifiers of rule SOR1
     */
    private String[] identifiers_SOR1 = {
        "penalty",
        "schedule",
        "alternativeClassroom",
        "lessonInTheWay"
    };

    /**
     * Returns the identifiers declared in rule SOR1
     *
     * @return the identifiers declared in rule SOR1
     */
    private String[] getDeclaredIdentifiers_SOR1() {
         return identifiers_SOR1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SOR1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SOR1(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherWalking";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Classroom";
            case 3: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SOR1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SOR1(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherWalking.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Classroom.class;
            case 3: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SOR1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SOR1(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 3: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SOR1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SOR1(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Classroom_1;
            case 3: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SOR1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SOR1() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SOR1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SOR1(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[2];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[3];
    }

    /**
     * Condition 0 of rule SOR1.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isAvailable(lessonInTheWay.getHour(), lessonInTheWay)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond_0() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_Lesson_1.getHour(), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule SOR1.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isSuitedFor(lessonInTheWay)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond_1() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule SOR1.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getHour().equals(lesson2.getHour())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond_2() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour()));
    }

    /**
     * Condition 3 of rule SOR1.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getClassroom().equals(lesson1.getClassroom())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond_3() {
        return (sss_scheduler_objects_Lesson_1.getClassroom().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom()));
    }

    /**
     * Condition 4 of rule SOR1.<p>
     * The original expression was:<br>
     * <code>lesson1.getClassroom().isSuitedFor(lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond_4() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom().isSuitedFor((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Checks whether some conditions of rule SOR1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR1_cond(int index) {
        switch (index) {
            case 0: return SOR1_cond_0();
            case 1: return SOR1_cond_1();
            case 2: return SOR1_cond_2();
            case 3: return SOR1_cond_3();
            case 4: return SOR1_cond_4();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SOR1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SOR1(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!SOR1_cond_4()) return false;
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_SOR1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                if (!SOR1_cond_0()) return false;
                if (!SOR1_cond_1()) return false;
                if (!SOR1_cond_2()) return false;
                if (!SOR1_cond_3()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SOR1
     */
    private void SOR1() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_1.getHour(), sss_scheduler_objects_Classroom_1);
      sss_scheduler_objects_Schedule_1.moveLesson((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1).getClassroom());
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1);
      retract(sss_scheduler_objects_Schedule_1);
      }



/* Move a lesson for which a teacher has to walk to a classroom where this is not the case. */
  
    /**
     * Identifiers of rule SOR2
     */
    private String[] identifiers_SOR2 = {
        "penalty",
        "schedule",
        "lessonInTheWay"
    };

    /**
     * Returns the identifiers declared in rule SOR2
     *
     * @return the identifiers declared in rule SOR2
     */
    private String[] getDeclaredIdentifiers_SOR2() {
         return identifiers_SOR2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SOR2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SOR2(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherWalking";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SOR2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SOR2(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherWalking.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SOR2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SOR2(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SOR2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SOR2(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SOR2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SOR2() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SOR2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SOR2(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherWalking) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[2];
    }

    /**
     * Condition 0 of rule SOR2.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getHour().equals(lesson2.getHour())</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR2_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour()));
    }

    /**
     * Condition 1 of rule SOR2.<p>
     * The original expression was:<br>
     * <code>lessonInTheWay.getClassroom().equals(classroom1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR2_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getClassroom().equals((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1.getClassroom())));
    }

    /**
     * Condition 2 of rule SOR2.<p>
     * The original expression was:<br>
     * <code>classroom1.isSuitedFor(lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR2_cond_2() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1.getClassroom()).isSuitedFor((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Condition 3 of rule SOR2.<p>
     * The original expression was:<br>
     * <code>classroom1.isAvailable(lesson2.getHour(), lesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR2_cond_3() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1.getClassroom()).isAvailable((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2)));
    }

    /**
     * Checks whether some conditions of rule SOR2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR2_cond(int index) {
        switch (index) {
            case 0: return SOR2_cond_0();
            case 1: return SOR2_cond_1();
            case 2: return SOR2_cond_2();
            case 3: return SOR2_cond_3();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SOR2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SOR2(int declIndex) {
        switch (declIndex) {
            case 0:
                if (!SOR2_cond_2()) return false;
                if (!SOR2_cond_3()) return false;
                return true;
            case 1:
                return true;
            case 2:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_SOR2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SOR2_cond_0()) return false;
                if (!SOR2_cond_1()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SOR2
     */
    private void SOR2() {
      sss_scheduler_objects_Schedule_1.moveLesson((sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson2).getHour(), (sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1.lesson1.getClassroom()));
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1);
      retract(sss_scheduler_objects_Schedule_1);
      }



/* Move a lesson in a time slot on which the teacher would rather not teach to a time slot were the teacher is available. */
  
    /**
     * Identifiers of rule SOR3
     */
    private String[] identifiers_SOR3 = {
        "penalty",
        "schedule",
        "lesson",
        "lessonHour2"
    };

    /**
     * Returns the identifiers declared in rule SOR3
     *
     * @return the identifiers declared in rule SOR3
     */
    private String[] getDeclaredIdentifiers_SOR3() {
         return identifiers_SOR3;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SOR3.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SOR3(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.Lesson";
            case 3: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SOR3.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SOR3(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            case 3: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SOR3.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SOR3(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 3: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SOR3.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SOR3(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_Lesson_1;
            case 3: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SOR3
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SOR3() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SOR3
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SOR3(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1 = (sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[2];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[3];
    }

    /**
     * Condition 0 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>lesson.getTeacher().equals(teacher)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getTeacher().equals((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher)));
    }

    /**
     * Condition 1 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.lessonHour)));
    }

    /**
     * Condition 2 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>teacher.getAvailability(lessonHour2).equals(Availability.AVAILABLE)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_2() {
        return ((sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher).getAvailability(sss_scheduler_objects_LessonHour_1).equals(Availability.AVAILABLE));
    }

    /**
     * Condition 3 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_3() {
        return (!(sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1.teacher).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassroom()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassroom()).isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule SOR3.<p>
     * The original expression was:<br>
     * <code>classInSchool.isAvailable(lessonHour2, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond_6() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule SOR3 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR3_cond(int index) {
        switch (index) {
            case 0: return SOR3_cond_0();
            case 1: return SOR3_cond_1();
            case 2: return SOR3_cond_2();
            case 3: return SOR3_cond_3();
            case 4: return SOR3_cond_4();
            case 5: return SOR3_cond_5();
            case 6: return SOR3_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SOR3 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SOR3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SOR3_cond_5()) return false;
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_SOR3(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SOR3_cond_0()) return false;
                if (!SOR3_cond_1()) return false;
                return true;
            case 3:
                if (!SOR3_cond_2()) return false;
                if (!SOR3_cond_3()) return false;
                if (!SOR3_cond_4()) return false;
                if (!SOR3_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SOR3
     */
    private void SOR3() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_LessonHour_1, (sss_scheduler_objects_Lesson_1.getClassroom()));
      retract(sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1);
      retract(sss_scheduler_objects_Schedule_1);
      }



	/**
	 * Rules for Classes
	 */
	 
/* Move a lesson of a class that is located on the 9th hour to a timeslot where it is not. */
  
    /**
     * Identifiers of rule SOR4
     */
    private String[] identifiers_SOR4 = {
        "penalty",
        "schedule",
        "alternativeLessonHour",
        "alternativeClassroom",
        "lesson"
    };

    /**
     * Returns the identifiers declared in rule SOR4
     *
     * @return the identifiers declared in rule SOR4
     */
    private String[] getDeclaredIdentifiers_SOR4() {
         return identifiers_SOR4;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SOR4.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SOR4(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyClass9thHour";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.LessonHour";
            case 3: return "sss.scheduler.objects.Classroom";
            case 4: return "sss.scheduler.objects.Lesson";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SOR4.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SOR4(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyClass9thHour.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            case 3: return sss.scheduler.objects.Classroom.class;
            case 4: return sss.scheduler.objects.Lesson.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SOR4.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SOR4(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyClass9thHour_1 = (sss.reasoner.penaltyObjects.PenaltyClass9thHour) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
            case 3: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 4: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SOR4.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SOR4(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyClass9thHour_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            case 3: return sss_scheduler_objects_Classroom_1;
            case 4: return sss_scheduler_objects_Lesson_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SOR4
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SOR4() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyClass9thHour_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_LessonHour_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_Lesson_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SOR4
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SOR4(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyClass9thHour_1 = (sss.reasoner.penaltyObjects.PenaltyClass9thHour) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[3];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[4];
    }

    /**
     * Condition 0 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_0() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.lessonHour)));
    }

    /**
     * Condition 1 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>lesson.getClassInSchool().equals(classInSchool)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_1() {
        return (sss_scheduler_objects_Lesson_1.getClassInSchool().equals((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.classInSchool)));
    }

    /**
     * Condition 2 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_3() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>classInSchool.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_4() {
        return ((sss_reasoner_penaltyObjects_PenaltyClass9thHour_1.classInSchool).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isAvailable(alternativeLessonHour, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule SOR4.<p>
     * The original expression was:<br>
     * <code>alternativeClassroom.isSuitedFor(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule SOR4 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR4_cond(int index) {
        switch (index) {
            case 0: return SOR4_cond_0();
            case 1: return SOR4_cond_1();
            case 2: return SOR4_cond_2();
            case 3: return SOR4_cond_3();
            case 4: return SOR4_cond_4();
            case 5: return SOR4_cond_5();
            case 6: return SOR4_cond_6();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SOR4 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SOR4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_SOR4(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                if (!SOR4_cond_0()) return false;
                if (!SOR4_cond_1()) return false;
                if (!SOR4_cond_2()) return false;
                if (!SOR4_cond_3()) return false;
                if (!SOR4_cond_4()) return false;
                if (!SOR4_cond_5()) return false;
                if (!SOR4_cond_6()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SOR4
     */
    private void SOR4() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Classroom_1);
      retract(sss_reasoner_penaltyObjects_PenaltyClass9thHour_1);
      retract(sss_scheduler_objects_Schedule_1);
      }


	 
/* Move a lesson that is located at the start or end of a day for a class to a free hour for that class. */
  
    /**
     * Identifiers of rule SOR5
     */
    private String[] identifiers_SOR5 = {
        "penalty",
        "schedule",
        "lessonHour2",
        "lesson",
        "classroom"
    };

    /**
     * Returns the identifiers declared in rule SOR5
     *
     * @return the identifiers declared in rule SOR5
     */
    private String[] getDeclaredIdentifiers_SOR5() {
         return identifiers_SOR5;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule SOR5.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_SOR5(int index) {
        switch (index) {
            case 0: return "sss.reasoner.penaltyObjects.PenaltyClassBetweenHours";
            case 1: return "sss.scheduler.objects.Schedule";
            case 2: return "sss.scheduler.objects.LessonHour";
            case 3: return "sss.scheduler.objects.Lesson";
            case 4: return "sss.scheduler.objects.Classroom";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule SOR5.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_SOR5(int index) {
        switch (index) {
            case 0: return sss.reasoner.penaltyObjects.PenaltyClassBetweenHours.class;
            case 1: return sss.scheduler.objects.Schedule.class;
            case 2: return sss.scheduler.objects.LessonHour.class;
            case 3: return sss.scheduler.objects.Lesson.class;
            case 4: return sss.scheduler.objects.Classroom.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule SOR5.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_SOR5(int index, Object value) {
        switch (index) {
            case 0: this.sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1 = (sss.reasoner.penaltyObjects.PenaltyClassBetweenHours) value; break;
            case 1: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 2: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
            case 3: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 4: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
        }
    }

    /**
     * Returns an object declared in the rule SOR5.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_SOR5(int index) {
        switch (index) {
            case 0: return sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1;
            case 1: return sss_scheduler_objects_Schedule_1;
            case 2: return sss_scheduler_objects_LessonHour_1;
            case 3: return sss_scheduler_objects_Lesson_1;
            case 4: return sss_scheduler_objects_Classroom_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule SOR5
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_SOR5() {
        return new Object[] {
                            sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_LessonHour_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Classroom_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule SOR5
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_SOR5(Object[] objects) {
        sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1 = (sss.reasoner.penaltyObjects.PenaltyClassBetweenHours) objects[0];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[1];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[2];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[3];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[4];
    }

    /**
     * Condition 0 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>!teacher.isScheduled(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_0() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.lessonHour), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>teacher.isAvailable(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_1() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.lessonHour), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 2 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>classInSchool.isAvailable(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_2() {
        return ((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.classInSchool).isAvailable((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.lessonHour), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>classroom.isAvailable(lessonHour1, lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_3() {
        return (sss_scheduler_objects_Classroom_1.isAvailable((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.lessonHour), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>classroom.isSuitedFor(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_4() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>classInSchool.hasStartOrEndingHour(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_5() {
        return ((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.classInSchool).hasStartOrEndingHour(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 6 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>lesson.getHour().equals(lessonHour2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_6() {
        return (sss_scheduler_objects_Lesson_1.getHour().equals(sss_scheduler_objects_LessonHour_1));
    }

    /**
     * Condition 7 of rule SOR5.<p>
     * The original expression was:<br>
     * <code>lesson.getClassInSchool().equals(classInSchool)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond_7() {
        return (sss_scheduler_objects_Lesson_1.getClassInSchool().equals((sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.classInSchool)));
    }

    /**
     * Checks whether some conditions of rule SOR5 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean SOR5_cond(int index) {
        switch (index) {
            case 0: return SOR5_cond_0();
            case 1: return SOR5_cond_1();
            case 2: return SOR5_cond_2();
            case 3: return SOR5_cond_3();
            case 4: return SOR5_cond_4();
            case 5: return SOR5_cond_5();
            case 6: return SOR5_cond_6();
            case 7: return SOR5_cond_7();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule SOR5 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_SOR5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_SOR5(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                if (!SOR5_cond_5()) return false;
                return true;
            case 3:
                if (!SOR5_cond_0()) return false;
                if (!SOR5_cond_1()) return false;
                if (!SOR5_cond_2()) return false;
                if (!SOR5_cond_6()) return false;
                if (!SOR5_cond_7()) return false;
                return true;
            case 4:
                if (!SOR5_cond_3()) return false;
                if (!SOR5_cond_4()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule SOR5
     */
    private void SOR5() {
      sss_scheduler_objects_Schedule_1.moveLesson(sss_scheduler_objects_Lesson_1, (sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1.lessonHour), sss_scheduler_objects_Classroom_1);
      retract(sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1);
      retract(sss_scheduler_objects_Schedule_1);
      }


  

    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "SOR1",
        "SOR2",
        "SOR3",
        "SOR4",
        "SOR5"
    };

    /**
     * Returns the name of the rules in this class file.
     *
     * @return the name of the rules in this class file.
     */
    public String[] getRuleNames() {
        return File_ruleNames;
    }

    /**
     * The number of declarations of the rules in this class file.
     */
    private static final int[] File_numberOfDeclarations = {
        4,
        3,
        4,
        5,
        5
    };

    /**
     * Returns the number of declarations of the rules in this class file.
     *
     * @return the number of declarations  of the rules in this class file.
     */
    public int[] getNumberOfDeclarations() {
        return File_numberOfDeclarations;
    }

    /**
     * The number of conditions of the rules in this class file.
     */
    private static final int[] File_numberOfConditions = {
        5,
        4,
        7,
        7,
        8
    };

    /**
     * Returns the number of conditions of the rules in this class file.
     *
     * @return the number of conditions  of the rules in this class file.
     */
    public int[] getNumberOfConditions() {
        return File_numberOfConditions;
    }

    /**
     * Checks whether a condition of some rule is satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param condIndex the index of the condition to be checked
     * @return <code>true</code> if the corresponding condition for the
     *          given rule is satisfied. <code>false</code> otherwise.
     */
    public boolean checkCondition(int ruleIndex, int condIndex) {
        switch (ruleIndex) {
            case 0: return SOR1_cond(condIndex);
            case 1: return SOR2_cond(condIndex);
            case 2: return SOR3_cond(condIndex);
            case 3: return SOR4_cond(condIndex);
            case 4: return SOR5_cond(condIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of some rule that depend only on
     * the given object are satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          the given rule are satisfied;
     *           <code>false</code> otherwise.
     */
    public boolean checkConditionsOnlyOf(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkConditionsOnlyOf_SOR1(declIndex);
            case 1: return checkConditionsOnlyOf_SOR2(declIndex);
            case 2: return checkConditionsOnlyOf_SOR3(declIndex);
            case 3: return checkConditionsOnlyOf_SOR4(declIndex);
            case 4: return checkConditionsOnlyOf_SOR5(declIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference only the elements declared up to the given index
     * are true.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all the conditions of a rule which
     *          reference only the elements declared up to the given index
     *          are satisfied; <code>false</code> otherwise.
     */
    public boolean checkCondForDeclaration(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkCondForDeclaration_SOR1(declIndex);
            case 1: return checkCondForDeclaration_SOR2(declIndex);
            case 2: return checkCondForDeclaration_SOR3(declIndex);
            case 3: return checkCondForDeclaration_SOR4(declIndex);
            case 4: return checkCondForDeclaration_SOR5(declIndex);
            default: return false;
        }
    }

    /**
     * Returns the class name of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class name of the declared object.
     */
    public String getDeclaredClassName(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClassName_SOR1(declIndex);
            case 1: return getDeclaredClassName_SOR2(declIndex);
            case 2: return getDeclaredClassName_SOR3(declIndex);
            case 3: return getDeclaredClassName_SOR4(declIndex);
            case 4: return getDeclaredClassName_SOR5(declIndex);
            default: return null;
        }
    }

    /**
     * Returns the class of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class of the declared object.
     */
    public Class getDeclaredClass(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClass_SOR1(declIndex);
            case 1: return getDeclaredClass_SOR2(declIndex);
            case 2: return getDeclaredClass_SOR3(declIndex);
            case 3: return getDeclaredClass_SOR4(declIndex);
            case 4: return getDeclaredClass_SOR5(declIndex);
            default: return null;
        }
    }

    /**
     * Fires one of the rules in this rule base.
     *
     * @param ruleIndex the index of the rule to be fired
     */
    protected void internalFireRule(int ruleIndex) {
        switch (ruleIndex) {
            case 0: SOR1(); break;
            case 1: SOR2(); break;
            case 2: SOR3(); break;
            case 3: SOR4(); break;
            case 4: SOR5(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 5;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_SOR1();
            case 1: return getDeclaredIdentifiers_SOR2();
            case 2: return getDeclaredIdentifiers_SOR3();
            case 3: return getDeclaredIdentifiers_SOR4();
            case 4: return getDeclaredIdentifiers_SOR5();
            default: return new String[0];
        }
    }

    /**
     * Sets an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @param value the value of the object being set.
     */
    public void setObject(int ruleIndex, int declIndex, Object value) {
        switch (ruleIndex) {
            case 0: setObject_SOR1(declIndex, value); break;
            case 1: setObject_SOR2(declIndex, value); break;
            case 2: setObject_SOR3(declIndex, value); break;
            case 3: setObject_SOR4(declIndex, value); break;
            case 4: setObject_SOR5(declIndex, value); break;
        }
    }

    /**
     * Returns an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @return the value of the corresponding object.
     */
    public Object getObject(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getObject_SOR1(declIndex);
            case 1: return getObject_SOR2(declIndex);
            case 2: return getObject_SOR3(declIndex);
            case 3: return getObject_SOR4(declIndex);
            case 4: return getObject_SOR5(declIndex);
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @return an object array of the variables bound to the
     *          declarations of some rule.
     */
    public Object[] getObjects(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getObjects_SOR1();
            case 1: return getObjects_SOR2();
            case 2: return getObjects_SOR3();
            case 3: return getObjects_SOR4();
            case 4: return getObjects_SOR5();
            default: return null;
        }
    }
    /**
     * Defines all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @param objects an object array of the variables bound to the
     *          declarations of some rule.
     */
    public void setObjects(int ruleIndex, Object[] objects) {
        switch (ruleIndex) {
            case 0: setObjects_SOR1(objects); break;
            case 1: setObjects_SOR2(objects); break;
            case 2: setObjects_SOR3(objects); break;
            case 3: setObjects_SOR4(objects); break;
            case 4: setObjects_SOR5(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.reasoner.penaltyObjects.PenaltyTeacherWalking sss_reasoner_penaltyObjects_PenaltyTeacherWalking_1;
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Classroom sss_scheduler_objects_Classroom_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.reasoner.penaltyObjects.PenaltyTeacherRatherNot sss_reasoner_penaltyObjects_PenaltyTeacherRatherNot_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;
    private sss.reasoner.penaltyObjects.PenaltyClass9thHour sss_reasoner_penaltyObjects_PenaltyClass9thHour_1;
    private sss.reasoner.penaltyObjects.PenaltyClassBetweenHours sss_reasoner_penaltyObjects_PenaltyClassBetweenHours_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_ScheduleOptimizationKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file ScheduleOptimizationKB.rules
 *
 * @version Jan 30, 2014
 */
public class ScheduleOptimizationKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public ScheduleOptimizationKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public ScheduleOptimizationKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_ScheduleOptimizationKB(this);
    }

}
