1.  Define the truth table (use truth table) for:
    
    a.  (P && Q) || R
        
        === === === ====== =============
        P   Q   R   P && Q (P && Q) || R
        === === === ====== =============
        T   T   T   T      T
        T   T   F   T      T
        T   F   T   F      T
        T   F   F   F      F
        F   T   T   F      T
        F   T   F   F      F
        F   F   T   F      T
        F   F   F   F      F
        === === === ====== =============
    
    b.  P && (Q || R)
        
        === === === ====== =============
        P   Q   R   Q || R P && (Q || R)
        === === === ====== =============
        T   T   T   T      T
        T   T   F   T      T
        T   F   T   T      T
        T   F   F   F      F
        F   T   T   T      F
        F   T   F   T      F
        F   F   T   T      F
        F   F   F   F      F
        === === === ====== =============
    
    c.  ~P -> (Q && R)
        
        === === === === ====== ==============
        P   Q   R   ~P  Q && R ~P -> (Q && R)
        === === === === ====== ==============
        T   T   T   F   T      T
        T   T   F   F   F      T
        T   F   T   F   F      T
        T   F   F   F   F      T
        F   T   T   T   T      T
        F   T   F   T   F      F
        F   F   T   T   F      F
        F   F   F   T   F      F
        === === === === ====== ==============

