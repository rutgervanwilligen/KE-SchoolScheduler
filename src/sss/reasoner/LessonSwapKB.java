package sss.reasoner;

import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Teacher;
import sss.scheduler.objects.ClassInSchool;
import sss.scheduler.objects.Classroom;
import sss.scheduler.objects.LessonHour;
import sss.scheduler.objects.Subject;
import sss.scheduler.objects.Schedule;

/**
 * Rule base used to swap lessons.
 */
  class Jeops_RuleBase_LessonSwapKB extends jeops.AbstractRuleBase {

  /* Rule to swap an unallocated and an allocated lesson. */
  
    /**
     * Identifiers of rule lessonSwap1
     */
    private String[] identifiers_lessonSwap1 = {
        "newLesson",
        "allocatedLesson",
        "schedule",
        "newClassroom",
        "newLessonHour"
    };

    /**
     * Returns the identifiers declared in rule lessonSwap1
     *
     * @return the identifiers declared in rule lessonSwap1
     */
    private String[] getDeclaredIdentifiers_lessonSwap1() {
         return identifiers_lessonSwap1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule lessonSwap1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_lessonSwap1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Schedule";
            case 3: return "sss.scheduler.objects.Classroom";
            case 4: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule lessonSwap1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_lessonSwap1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Schedule.class;
            case 3: return sss.scheduler.objects.Classroom.class;
            case 4: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule lessonSwap1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_lessonSwap1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 3: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 4: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule lessonSwap1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_lessonSwap1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Lesson_2;
            case 2: return sss_scheduler_objects_Schedule_1;
            case 3: return sss_scheduler_objects_Classroom_1;
            case 4: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule lessonSwap1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_lessonSwap1() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Lesson_2,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule lessonSwap1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_lessonSwap1(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[2];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[3];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[4];
    }

    /**
     * Condition 0 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatableLesson(newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatableLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>schedule.containsAllocatedLesson(allocatedLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsAllocatedLesson(sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 2 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>newTeacher.isAvailable(allocatedLessonHour, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_2() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 3 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>!newTeacher.isScheduled(allocatedLessonHour, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_3() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>newClass.isAvailable(allocatedLessonHour, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_4() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>newClassroom.isAvailable(allocatedLessonHour, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_5() {
        return (sss_scheduler_objects_Classroom_1.isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>newClassroom.isSuitedFor(allocatedSubject)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor((sss_scheduler_objects_Lesson_2.getSubject())));
    }

    /**
     * Condition 7 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>allocatedTeacher.isAvailable(newLessonHour, allocatedLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_7() {
        return ((sss_scheduler_objects_Lesson_2.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 8 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>!allocatedTeacher.isScheduled(newLessonHour, allocatedLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_8() {
        return (!(sss_scheduler_objects_Lesson_2.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 9 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>allocatedClass.isAvailable(newLessonHour, allocatedLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_9() {
        return ((sss_scheduler_objects_Lesson_2.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 10 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom.isAvailable(newLessonHour, allocatedLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_10() {
        return ((sss_scheduler_objects_Lesson_2.getClassroom()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 11 of rule lessonSwap1.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom.isSuitedFor(newSubject)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond_11() {
        return ((sss_scheduler_objects_Lesson_2.getClassroom()).isSuitedFor((sss_scheduler_objects_Lesson_1.getSubject())));
    }

    /**
     * Checks whether some conditions of rule lessonSwap1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap1_cond(int index) {
        switch (index) {
            case 0: return lessonSwap1_cond_0();
            case 1: return lessonSwap1_cond_1();
            case 2: return lessonSwap1_cond_2();
            case 3: return lessonSwap1_cond_3();
            case 4: return lessonSwap1_cond_4();
            case 5: return lessonSwap1_cond_5();
            case 6: return lessonSwap1_cond_6();
            case 7: return lessonSwap1_cond_7();
            case 8: return lessonSwap1_cond_8();
            case 9: return lessonSwap1_cond_9();
            case 10: return lessonSwap1_cond_10();
            case 11: return lessonSwap1_cond_11();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule lessonSwap1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_lessonSwap1(int declIndex) {
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
    private boolean checkCondForDeclaration_lessonSwap1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!lessonSwap1_cond_2()) return false;
                if (!lessonSwap1_cond_3()) return false;
                if (!lessonSwap1_cond_4()) return false;
                if (!lessonSwap1_cond_11()) return false;
                return true;
            case 2:
                if (!lessonSwap1_cond_0()) return false;
                if (!lessonSwap1_cond_1()) return false;
                return true;
            case 3:
                if (!lessonSwap1_cond_5()) return false;
                if (!lessonSwap1_cond_6()) return false;
                return true;
            case 4:
                if (!lessonSwap1_cond_7()) return false;
                if (!lessonSwap1_cond_8()) return false;
                if (!lessonSwap1_cond_9()) return false;
                if (!lessonSwap1_cond_10()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule lessonSwap1
     */
    private void lessonSwap1() {
      sss_scheduler_objects_Lesson_1.setClassroom(sss_scheduler_objects_Classroom_1);
      sss_scheduler_objects_Lesson_1.setHour(sss_scheduler_objects_LessonHour_1);
      sss_scheduler_objects_Schedule_1.swapLessons(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_2);
      // System.out.println("lessonSwap1 fired");
      modified(sss_scheduler_objects_Schedule_1);
      modified(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Lesson_2);
      }


  
  /* Rule to rotate an unallocated and two allocated lessons. */
  
    /**
     * Identifiers of rule lessonSwap2
     */
    private String[] identifiers_lessonSwap2 = {
        "newLesson",
        "allocatedLesson1",
        "allocatedLesson2",
        "schedule",
        "newClassroom",
        "newLessonHour"
    };

    /**
     * Returns the identifiers declared in rule lessonSwap2
     *
     * @return the identifiers declared in rule lessonSwap2
     */
    private String[] getDeclaredIdentifiers_lessonSwap2() {
         return identifiers_lessonSwap2;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule lessonSwap2.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_lessonSwap2(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Lesson";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Lesson";
            case 3: return "sss.scheduler.objects.Schedule";
            case 4: return "sss.scheduler.objects.Classroom";
            case 5: return "sss.scheduler.objects.LessonHour";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule lessonSwap2.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_lessonSwap2(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Lesson.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Lesson.class;
            case 3: return sss.scheduler.objects.Schedule.class;
            case 4: return sss.scheduler.objects.Classroom.class;
            case 5: return sss.scheduler.objects.LessonHour.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule lessonSwap2.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_lessonSwap2(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 1: this.sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Lesson_3 = (sss.scheduler.objects.Lesson) value; break;
            case 3: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 4: this.sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) value; break;
            case 5: this.sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) value; break;
        }
    }

    /**
     * Returns an object declared in the rule lessonSwap2.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_lessonSwap2(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Lesson_1;
            case 1: return sss_scheduler_objects_Lesson_2;
            case 2: return sss_scheduler_objects_Lesson_3;
            case 3: return sss_scheduler_objects_Schedule_1;
            case 4: return sss_scheduler_objects_Classroom_1;
            case 5: return sss_scheduler_objects_LessonHour_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule lessonSwap2
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_lessonSwap2() {
        return new Object[] {
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Lesson_2,
                            sss_scheduler_objects_Lesson_3,
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Classroom_1,
                            sss_scheduler_objects_LessonHour_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule lessonSwap2
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_lessonSwap2(Object[] objects) {
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[0];
        sss_scheduler_objects_Lesson_2 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Lesson_3 = (sss.scheduler.objects.Lesson) objects[2];
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[3];
        sss_scheduler_objects_Classroom_1 = (sss.scheduler.objects.Classroom) objects[4];
        sss_scheduler_objects_LessonHour_1 = (sss.scheduler.objects.LessonHour) objects[5];
    }

    /**
     * Condition 0 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>schedule.containsUnallocatableLesson(newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsUnallocatableLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 1 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>schedule.containsAllocatedLesson(allocatedLesson1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_1() {
        return (sss_scheduler_objects_Schedule_1.containsAllocatedLesson(sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 2 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>schedule.containsAllocatedLesson(allocatedLesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_2() {
        return (sss_scheduler_objects_Schedule_1.containsAllocatedLesson(sss_scheduler_objects_Lesson_3));
    }

    /**
     * Condition 3 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>newTeacher.isAvailable(allocatedLessonHour1, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_3() {
        return ((sss_scheduler_objects_Lesson_1.getTeacher()).isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 4 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>!newTeacher.isScheduled(allocatedLessonHour1, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_4() {
        return (!(sss_scheduler_objects_Lesson_1.getTeacher()).isScheduled((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 5 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>newClass.isAvailable(allocatedLessonHour1, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_5() {
        return ((sss_scheduler_objects_Lesson_1.getClassInSchool()).isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 6 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>newClassroom.isAvailable(allocatedLessonHour1, newLesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_6() {
        return (sss_scheduler_objects_Classroom_1.isAvailable((sss_scheduler_objects_Lesson_2.getHour()), sss_scheduler_objects_Lesson_1));
    }

    /**
     * Condition 7 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>newClassroom.isSuitedFor(allocatedSubject1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_7() {
        return (sss_scheduler_objects_Classroom_1.isSuitedFor((sss_scheduler_objects_Lesson_2.getSubject())));
    }

    /**
     * Condition 8 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedTeacher1.isAvailable(allocatedLessonHour2, allocatedLesson1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_8() {
        return ((sss_scheduler_objects_Lesson_2.getTeacher()).isAvailable((sss_scheduler_objects_Lesson_3.getHour()), sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 9 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>!allocatedTeacher1.isScheduled(allocatedLessonHour2, allocatedLesson1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_9() {
        return (!(sss_scheduler_objects_Lesson_2.getTeacher()).isScheduled((sss_scheduler_objects_Lesson_3.getHour()), sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 10 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClass1.isAvailable(allocatedLessonHour2, allocatedLesson1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_10() {
        return ((sss_scheduler_objects_Lesson_2.getClassInSchool()).isAvailable((sss_scheduler_objects_Lesson_3.getHour()), sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 11 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom1.isAvailable(allocatedLessonHour2, allocatedLesson1)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_11() {
        return ((sss_scheduler_objects_Lesson_2.getClassroom()).isAvailable((sss_scheduler_objects_Lesson_3.getHour()), sss_scheduler_objects_Lesson_2));
    }

    /**
     * Condition 12 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom1.isSuitedFor(allocatedSubject2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_12() {
        return ((sss_scheduler_objects_Lesson_2.getClassroom()).isSuitedFor((sss_scheduler_objects_Lesson_3.getSubject())));
    }

    /**
     * Condition 13 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedTeacher2.isAvailable(newLessonHour, allocatedLesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_13() {
        return ((sss_scheduler_objects_Lesson_3.getTeacher()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_3));
    }

    /**
     * Condition 14 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>!allocatedTeacher2.isScheduled(newLessonHour, allocatedLesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_14() {
        return (!(sss_scheduler_objects_Lesson_3.getTeacher()).isScheduled(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_3));
    }

    /**
     * Condition 15 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClass2.isAvailable(newLessonHour, allocatedLesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_15() {
        return ((sss_scheduler_objects_Lesson_3.getClassInSchool()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_3));
    }

    /**
     * Condition 16 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom2.isAvailable(newLessonHour, allocatedLesson2)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_16() {
        return ((sss_scheduler_objects_Lesson_3.getClassroom()).isAvailable(sss_scheduler_objects_LessonHour_1, sss_scheduler_objects_Lesson_3));
    }

    /**
     * Condition 17 of rule lessonSwap2.<p>
     * The original expression was:<br>
     * <code>allocatedClassroom2.isSuitedFor(newSubject)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond_17() {
        return ((sss_scheduler_objects_Lesson_3.getClassroom()).isSuitedFor((sss_scheduler_objects_Lesson_1.getSubject())));
    }

    /**
     * Checks whether some conditions of rule lessonSwap2 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean lessonSwap2_cond(int index) {
        switch (index) {
            case 0: return lessonSwap2_cond_0();
            case 1: return lessonSwap2_cond_1();
            case 2: return lessonSwap2_cond_2();
            case 3: return lessonSwap2_cond_3();
            case 4: return lessonSwap2_cond_4();
            case 5: return lessonSwap2_cond_5();
            case 6: return lessonSwap2_cond_6();
            case 7: return lessonSwap2_cond_7();
            case 8: return lessonSwap2_cond_8();
            case 9: return lessonSwap2_cond_9();
            case 10: return lessonSwap2_cond_10();
            case 11: return lessonSwap2_cond_11();
            case 12: return lessonSwap2_cond_12();
            case 13: return lessonSwap2_cond_13();
            case 14: return lessonSwap2_cond_14();
            case 15: return lessonSwap2_cond_15();
            case 16: return lessonSwap2_cond_16();
            case 17: return lessonSwap2_cond_17();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule lessonSwap2 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_lessonSwap2(int declIndex) {
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
            case 5:
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
    private boolean checkCondForDeclaration_lessonSwap2(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!lessonSwap2_cond_3()) return false;
                if (!lessonSwap2_cond_4()) return false;
                if (!lessonSwap2_cond_5()) return false;
                return true;
            case 2:
                if (!lessonSwap2_cond_8()) return false;
                if (!lessonSwap2_cond_9()) return false;
                if (!lessonSwap2_cond_10()) return false;
                if (!lessonSwap2_cond_11()) return false;
                if (!lessonSwap2_cond_12()) return false;
                if (!lessonSwap2_cond_17()) return false;
                return true;
            case 3:
                if (!lessonSwap2_cond_0()) return false;
                if (!lessonSwap2_cond_1()) return false;
                if (!lessonSwap2_cond_2()) return false;
                return true;
            case 4:
                if (!lessonSwap2_cond_6()) return false;
                if (!lessonSwap2_cond_7()) return false;
                return true;
            case 5:
                if (!lessonSwap2_cond_13()) return false;
                if (!lessonSwap2_cond_14()) return false;
                if (!lessonSwap2_cond_15()) return false;
                if (!lessonSwap2_cond_16()) return false;
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule lessonSwap2
     */
    private void lessonSwap2() {
      sss_scheduler_objects_Lesson_1.setClassroom(sss_scheduler_objects_Classroom_1);
      sss_scheduler_objects_Lesson_1.setHour(sss_scheduler_objects_LessonHour_1);
      sss_scheduler_objects_Schedule_1.swapLessons(sss_scheduler_objects_Lesson_1, sss_scheduler_objects_Lesson_2);
      sss_scheduler_objects_Schedule_1.swapLessons(sss_scheduler_objects_Lesson_2, sss_scheduler_objects_Lesson_3);
      // System.out.println("lessonSwap1 fired");
      modified(sss_scheduler_objects_Schedule_1);
      modified(sss_scheduler_objects_Lesson_1);
      modified(sss_scheduler_objects_Lesson_2);
      modified(sss_scheduler_objects_Lesson_3);
      }


  

    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "lessonSwap1",
        "lessonSwap2"
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
        5,
        6
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
        12,
        18
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
            case 0: return lessonSwap1_cond(condIndex);
            case 1: return lessonSwap2_cond(condIndex);
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
            case 0: return checkConditionsOnlyOf_lessonSwap1(declIndex);
            case 1: return checkConditionsOnlyOf_lessonSwap2(declIndex);
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
            case 0: return checkCondForDeclaration_lessonSwap1(declIndex);
            case 1: return checkCondForDeclaration_lessonSwap2(declIndex);
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
            case 0: return getDeclaredClassName_lessonSwap1(declIndex);
            case 1: return getDeclaredClassName_lessonSwap2(declIndex);
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
            case 0: return getDeclaredClass_lessonSwap1(declIndex);
            case 1: return getDeclaredClass_lessonSwap2(declIndex);
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
            case 0: lessonSwap1(); break;
            case 1: lessonSwap2(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 2;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_lessonSwap1();
            case 1: return getDeclaredIdentifiers_lessonSwap2();
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
            case 0: setObject_lessonSwap1(declIndex, value); break;
            case 1: setObject_lessonSwap2(declIndex, value); break;
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
            case 0: return getObject_lessonSwap1(declIndex);
            case 1: return getObject_lessonSwap2(declIndex);
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
            case 0: return getObjects_lessonSwap1();
            case 1: return getObjects_lessonSwap2();
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
            case 0: setObjects_lessonSwap1(objects); break;
            case 1: setObjects_lessonSwap2(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_2;
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Classroom sss_scheduler_objects_Classroom_1;
    private sss.scheduler.objects.LessonHour sss_scheduler_objects_LessonHour_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_3;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_LessonSwapKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file LessonSwapKB.rules
 *
 * @version Jan 29, 2014
 */
public class LessonSwapKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public LessonSwapKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public LessonSwapKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_LessonSwapKB(this);
    }

}
