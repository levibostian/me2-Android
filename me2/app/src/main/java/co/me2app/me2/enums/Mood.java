package co.me2app.me2.enums;

public enum Mood {
    AWESOME {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitAwesome();
        }
    },
    GOOD {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitGood();
        }
    },
    AVERAGE {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitAverage();
        }
    },
    LOVING {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitLoving();
        }
    },
    SAD {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitSad();
        }
    },
    LONELY {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitLonely();
        }
    },
    SCARED {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitScared();
        }
    },
    HURT {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitHurt();
        }
    },
    ANGRY {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitAngry();
        }
    };

    public abstract <E> E accept(Visitor<E> visitor);

    public interface Visitor <E> {
        E visitAwesome();
        E visitGood();
        E visitAverage();
        E visitLoving();
        E visitSad();
        E visitLonely();
        E visitScared();
        E visitHurt();
        E visitAngry();
    }
}
