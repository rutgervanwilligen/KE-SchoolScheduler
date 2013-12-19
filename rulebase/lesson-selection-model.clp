(defrule test-rule-1
	"This is just a test rule."
	(Lesson {subject == "LO"} )
	=>
	(modify (Lesson {rank = rank + 1} )))