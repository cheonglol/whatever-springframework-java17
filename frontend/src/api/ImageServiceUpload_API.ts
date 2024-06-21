// ImageServiceUpload_API.ts

export const uploadImage = async (base64Image: string, filename: string) => {
    try {
        const response = await fetch('http://localhost:8080/images/upload', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                image: base64Image,
                filename: filename,
            }),
        });
        if (!response.ok) {
            throw new Error(`HTTP error status: ${response.status}`);
        }
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }
}
