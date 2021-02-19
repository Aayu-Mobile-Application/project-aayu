import React from 'react';
import {
    StyleSheet,
    View,
    Text,
    Image
} from 'react-native';

import { appIcons, images, colours, cntSizes, appFonts } from '../constants';
import { TouchableOpacity } from 'react-native-gesture-handler';




///make space for custom card
//consider of removing code
// const ReqsFrSearchBy = ({ icon, label, detail }) => {
//     return (
//         <View style={{ flexDirection: 'row' }}>
//             <View style={{ flex: 1, flexDirection: 'row', alignItems: 'center' }}>
//                 <Image
//                     source={icon}
//                     resizeMode="cover"
//                     style={{
//                         tintColor: colours.green,
//                         width: 30,
//                         height: 30
//                     }}
//                 />

//                 <Text style={{ marginLeft: cntSizes.baseSpc, color: colours.gray, ...appFonts.h2 }}>{label}</Text>
//             </View>
//             <View style={{ flex: 1, alignItems: 'flex-end' }}>
//                 <Text style={{ marginLeft: cntSizes.baseSpc, color: colours.green, ...appFonts.h2 }}>{detail}</Text>
//             </View>
//         </View>
//     )
// }

const Help = ({ navigation }) => {

    // Render

    function renderHeader() {
        return (
            <View
                style={{
                    position: 'absolute',
                    top: 50,
                    left: cntSizes.padding,
                    right: cntSizes.padding
                }}
            >
                <View style={{ flexDirection: 'row' }}>
                    <View style={{ flex: 1 }}>
                        <TouchableOpacity
                            style={{ width: 40, height: 40, alignItems: 'center', justifyContent: 'center', borderRadius: 20, backgroundColor: 'rgba(255,255,255,0.5)' }}
                            onPress={() => { navigation.navigate("HomeScreen") }}
                        >
                            <Image
                                source={appIcons.bckArrw}
                                resizeMode="contain"
                                style={{
                                    width: 20,
                                    height: 20
                                }}
                            />
                        </TouchableOpacity>
                    </View>
                    {/* <TouchableOpacity
                        style={{ flex: 1, alignItems: 'flex-end', justifyContent: 'center' }}
                        onPress={() => { console.log("Focus on pressed") }}
                    >
                        <Image
                            source={icons.focus}
                            resizeMode="contain"
                            style={{
                                width: 25,
                                height: 25
                            }}
                        />
                    </TouchableOpacity> */}
                </View>

                <View style={{ flexDirection: 'row', marginTop: "10%" }}>
                    <View style={{ flex: 1 }}>
                        <Text style={{ color: colours.white, ...appFonts.mainTitle2 }}>Glory Mantas</Text>
                    </View>
                    <View style={{ flex: 1 }}></View>
                </View>
            </View>
        )
    }


    return (
        <View style={styles.container}>
            {/* Banner Photo */}
            <View style={{ height: "35%" }}>
                <Image
                    source={images.bannerHlp}
                    resizeMode="cover"
                    style={{
                        width: '100%',
                        height: '100%'
                    }}
                />
            </View>

            {/* Requirements */}
            <View
                style={{
                    flex: 1,
                    marginTop: -40,
                    backgroundColor: colours.lightGray,
                    borderTopLeftRadius: 40,
                    borderTopRightRadius: 40,
                    paddingVertical: cntSizes.paddingObj
                }}
            >
                <Text style={{ paddingHorizontal: cntSizes.paddingObj, color: colours.green, ...appFonts.h1 }}>Help</Text>

              {/* renderCards */}
            </View>

            {renderHeader()}
        </View>
    )

}

const styles = StyleSheet.create({
    container: {
        flex: 1
    }
})

export default Help;