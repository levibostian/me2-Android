package com.brightspotinnovations.me2;

public enum  SituationCategory {
    FAMILY {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitFamily();
        }
    },
    FRIENDS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitFriends();
        }
    },
    PETS {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitPets();
        }
    },
    SCHOOL {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitSchool();
        }
    },
    PERSONAL {
        @Override
        public <E> E accept(Visitor<E> visitor) {
            return visitor.visitPersonal();
        }
    };

    public abstract <E> E accept(Visitor<E> visitor);

    public interface Visitor <E> {
        E visitFamily();
        E visitFriends();
        E visitPets();
        E visitSchool();
        E visitPersonal();
    }
}
