package com.company;

public class Word {
    String e = "able,alpha,animal,ankle,applaud,april,athlete,attach,attract,awhile,bags,ball,bat,began,between,books,bridge,brother,burglar,cat,change,clasp,computer,describe,display,dog,eclipse,explain,fact,fish,five,freedom,freight,friday,fruit,games,gather,glance,grade,grape,grapefruit,gravity,hello,human,hungry,january,later,laundry,lists,main,mats,monday,mother,mouse,neighbor,nowhere,numbers,orange,person,play,playground,rapid,red,sacks,sandwich,saturday,secret,shows,singer,sister,six,slimy,slippery,snowflake,space,spring,stranger,sunday,switch,target,television,these,thirsty,thread,thursday,trouble,tuesday,twilight,vegetable,vein,watch,wednesday,weigh,where,whisper,whistle,words,world,worth,yellow";
    String h = "abruptly,absurd,abyss,affix,askew,avenue,awkward,axiom,azure,bagpipes,bandwagon,banjo,bayou,beekeeper,bikini,blitz,blizzard,boggle,bookworm,boxcar,boxful,buckaroo,buffalo,buffoon,buxom,buzzard,buzzing,buzzwords,caliph,cobweb,cockiness,croquet,crypt,curacao,cycle,daiquiri,dirndl,disavow,dizzying,duplex,dwarves,embezzle,equip,espionage,euouae,exodus,faking,fishhook,fixable,fjord,flapjack,flopping,fluffiness,flyby,foxglove,frazzled,frizzled,fuchsia,funny,gabby,galaxy,galvanize,gazebo,giaour,gizmo,glowworm,glyph,gnarly,gnostic,gossip,grogginess,haiku,haphazard,hyphen,iatrogenic,icebox,injury,ivory,ivy,jackpot,jaundice,jawbreaker,jaywalk,jazziest,jazzy,jelly,jigsaw,jinx,jiujitsu,jockey,jogging,joking,jovial,joyful,juicy,jukebox,jumbo,kayak,kazoo,keyhole";
    String[] hardA = h.split(",");
    String[] easyA = e.split(",");
    String diffL;
    public Word(){}
    public Word(String l){
        diffL=l;
    }
    public String returnWord(){
        String rv = "";
        int randI =0;
        if(diffL.equals("e")){
            randI = (int)(Math.random()*100);
            rv=easyA[randI];
        } else {
            randI = (int)(Math.random()*100);
            rv=hardA[randI];
        }
        return rv;
    }
}

