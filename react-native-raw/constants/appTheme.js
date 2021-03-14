import { Dimensions } from "react-native";
const { width, height } = Dimensions.get("window");

export const cntSizes = {


    //basic com sizes
    
   
    fontNrml: 14,
    radius: 12,
    paddingObj: 24,
    baseSpc:8,


    //dimensions of mobApp
    width,
    height,

    //App fonts
    bdy1:30,
    bdy2:23,
    bdy3:15,
    bdy4:12,
    bdy5:18,
    mainTitle: 45,
    h2:22,
    h1:30,
    h4:15,
    h3:16

}

export const colours = {
    // base colors
    green: "#00996D", 
    gray: "#606d87",   // Gray
    black: "#1E1F20",
    white: "#FFFFFF",
    lightGray: "#eff2f5",
    lightGreen:"#00e673"
    //gray: "#BEC1D2",
};

export const appFonts = {
    mainTitle: { fontFamily: "Roboto", fontSize: cntSizes.largeTitle, lineHeight: 55 },
    h1: { fontFamily: "Roboto", fontSize: cntSizes.h1, lineHeight: 36 },
    h2: { fontFamily: "Roboto", fontSize: cntSizes.h2, lineHeight: 30 },
    bdy1: { fontFamily: "Roboto", fontSize: cntSizes.bdy1, lineHeight: 36 },
    bdy2: { fontFamily: "Roboto", fontSize: cntSizes.bdy2, lineHeight: 30 },
    bdy3: { fontFamily: "Roboto", fontSize: cntSizes.bdy3, lineHeight: 22 },
    bdy4: { fontFamily: "Roboto", fontSize: cntSizes.bdy4, lineHeight: 22 },
    bdy5: { fontFamily: "Roboto", fontSize: cntSizes.bdy5, lineHeight: 38 },
    h3: { fontFamily: "Roboto", fontSize: cntSizes.h3, lineHeight: 22 },
    h4: { fontFamily: "Roboto", fontSize: cntSizes.h4, lineHeight: 22 },

};

const appTheme = { colours, cntSizes, appFonts };

export default appTheme;